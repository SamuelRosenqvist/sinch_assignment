package polish_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ExpressionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ExpressionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String expressionNotFoundHandler(ExpressionNotFoundException ex) {
        return ex.getMessage();
    }
}