package utils.custom_exceptions;

public class InvalidReimbursementTicketException extends RuntimeException {

    public InvalidReimbursementTicketException() {
    }

    public InvalidReimbursementTicketException(String message) {
        super(message);
    }

    public InvalidReimbursementTicketException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidReimbursementTicketException(Throwable cause) {
        super(cause);
    }

    public InvalidReimbursementTicketException(String message, Throwable cause, boolean enableSuppression,
                                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
