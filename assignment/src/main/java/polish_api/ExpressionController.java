package polish_api;

import java.rmi.ServerException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class ExpressionController {

    private final ExpressionRepository repository;
    private final ExpressionModelAssembler assembler;

    ExpressionController(ExpressionRepository repository, ExpressionModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/expressions")
    CollectionModel<EntityModel<PolishExpression>> all() {

        List<EntityModel<PolishExpression>> expressions = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(expressions, linkTo(methodOn(ExpressionController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/expressions")
    PolishExpression newExpression(@RequestBody PolishExpression newExpression) {
        newExpression.setResult(newExpression.getResult()); //Little unsure but it works.
        return repository.save(newExpression);
    }


    // Single item

    @GetMapping("/expressions/{id}")
    EntityModel<PolishExpression> one(@PathVariable Long id) {

        PolishExpression polishExpression = repository.findById(id) //
                .orElseThrow(() -> new ExpressionNotFoundException(id));

        return assembler.toModel(polishExpression);
    }

    @PutMapping("/expressions/{id}")
    PolishExpression replacePolishExpression(@RequestBody PolishExpression newPolishExpression, @PathVariable Long id) {

        return repository.findById(id)
                .map(expression -> {
                    expression.setExpr(newPolishExpression.getExpr());
                    expression.setResult(newPolishExpression.getResult());
                    return repository.save(expression);
                })
                .orElseGet(() -> {
                    newPolishExpression.setId(id);
                    return repository.save(newPolishExpression);
                });
    }

    @DeleteMapping("/expressions/{id}")
    void deletePolishExpression(@PathVariable Long id) {
        repository.deleteById(id);
    }

}