package bsuir.by.labWord2.thread;

/**
 * Created by Сергей on 18.03.2017.
 */
public class ResourсeException extends Exception {
    public ResourсeException() {
        super();
    }
    public ResourсeException(String message, Throwable cause) {
        super(message, cause);
    }
    public ResourсeException(String message) {
        super(message);
    }
    public ResourсeException(Throwable cause) {
        super(cause);
    }
}