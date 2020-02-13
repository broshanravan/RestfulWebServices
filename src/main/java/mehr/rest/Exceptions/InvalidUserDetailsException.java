package mehr.rest.Exceptions;

public class InvalidUserDetailsException extends RuntimeException {

    public InvalidUserDetailsException(String message) {
        super(message);
    }
}