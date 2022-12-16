package com.revature.erts.utils.custom_exceptions;

public class InvalidReimbursementTypeException extends RuntimeException {

    public InvalidReimbursementTypeException() {
    }

    public InvalidReimbursementTypeException(String message) {
        super(message);
    }

    public InvalidReimbursementTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidReimbursementTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidReimbursementTypeException(String message, Throwable cause, boolean enableSuppression,
                                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
