package Exeptions;

public class NullException extends RuntimeException{
    public NullException() {
        super("Вы ввели неверные данные!");
    }
}
