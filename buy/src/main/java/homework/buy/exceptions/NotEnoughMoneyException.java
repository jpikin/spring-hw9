package homework.buy.exceptions;

public class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException() {
        super("Недостаточное денег для оплаты товара");
    }

}
