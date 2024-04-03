package com.felipe.business.exception;

public class DataIntegrityViolationException extends RuntimeException {

    public DataIntegrityViolationException(String mensagem) {
        super(mensagem);
    }
}
