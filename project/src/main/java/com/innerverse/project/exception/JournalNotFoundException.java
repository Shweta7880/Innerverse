package com.innerverse.project.exception;

public class JournalNotFoundException extends RuntimeException{
    public JournalNotFoundException(String message) {
        super(message);
    }
}
