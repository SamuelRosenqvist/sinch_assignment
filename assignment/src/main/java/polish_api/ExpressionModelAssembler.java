package polish_api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class ExpressionModelAssembler implements RepresentationModelAssembler<PolishExpression, EntityModel<PolishExpression>> {

    @Override
    public EntityModel<PolishExpression> toModel(PolishExpression polishExpression) {

        return EntityModel.of(polishExpression, //
                linkTo(methodOn(ExpressionController.class).one(polishExpression.getId())).withSelfRel(),
                linkTo(methodOn(ExpressionController.class).all()).withRel("expressions"));
    }
}