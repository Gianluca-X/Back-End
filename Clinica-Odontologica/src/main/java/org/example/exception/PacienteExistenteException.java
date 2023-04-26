package org.example.exception;

public class PacienteExistenteException extends RuntimeException{
    public PacienteExistenteException ( String message ) {
        super( message );
    }
}
