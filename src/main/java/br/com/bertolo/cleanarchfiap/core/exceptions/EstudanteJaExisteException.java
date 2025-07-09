package br.com.bertolo.cleanarchfiap.core.exceptions;

public class EstudanteJaExisteException extends RuntimeException {
    public EstudanteJaExisteException(String message) {
        super(message);
    }
}
