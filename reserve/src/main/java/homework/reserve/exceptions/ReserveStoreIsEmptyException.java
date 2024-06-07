package homework.reserve.exceptions;

public class ReserveStoreIsEmptyException extends Exception {
    public ReserveStoreIsEmptyException() {
        super("Товар не зарезервирован");
    }
}
