package homework.reserve.exceptions;

public class NotEnoughQuantityException extends Exception{
    public NotEnoughQuantityException() {
        super("Недостаточное количество для списания");
    }

}
