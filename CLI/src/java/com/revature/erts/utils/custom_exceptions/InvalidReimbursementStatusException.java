package com.revature.erts.utils.custom_exceptions;

public class InvalidReimbursementStatusException extends RuntimeException {

    public InvalidReimbursementStatusException() {
    }

    public InvalidReimbursementStatusException(String message) {
        super(message);
    }

    public InvalidReimbursementStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidReimbursementStatusException(Throwable cause) {
        super(cause);
    }

    public InvalidReimbursementStatusException(String message, Throwable cause, boolean enableSuppression,
                                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}