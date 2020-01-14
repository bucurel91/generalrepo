package com.endava.exceptions;

public class NotInitializedWebDriverException extends Exception{

    public NotInitializedWebDriverException(String message, Throwable error) {
        super(message, error);
    }
}
