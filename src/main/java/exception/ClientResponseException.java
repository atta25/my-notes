package exception;

public class ClientResponseException extends RuntimeException{
    public ClientResponseException(String message) {
        super(message);
    }
}
