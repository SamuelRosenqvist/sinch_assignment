package polish_api;

class ExpressionNotFoundException extends RuntimeException {

    ExpressionNotFoundException(Long id) {
        super("Could not find expression " + id);
    }
}