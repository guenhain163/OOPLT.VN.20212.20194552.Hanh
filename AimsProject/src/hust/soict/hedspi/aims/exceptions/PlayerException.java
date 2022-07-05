package hust.soict.hedspi.aims.exceptions;

public class PlayerException extends Exception {
    private static final long serialVersionUID = 1L;

    public PlayerException() {

    }

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(Throwable cause) {
        super(cause);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
