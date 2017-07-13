package br.com.secharpe.exception;

public class SistemaException extends Exception {

    private static final long serialVersionUID = 1L;

    public SistemaException() {
        super("Mensagem padrão da exception!");
    }

    public SistemaException(String message) {
        super(message);
    }
}
