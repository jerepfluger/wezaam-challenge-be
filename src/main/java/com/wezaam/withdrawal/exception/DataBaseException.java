package com.wezaam.withdrawal.exception;

public class DataBaseException extends Exception {

    public DataBaseException() {
        super();
    }

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }
}
