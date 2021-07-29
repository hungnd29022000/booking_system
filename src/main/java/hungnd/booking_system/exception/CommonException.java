package hungnd.booking_system.exception;

public class CommonException extends Exception{
    private int code;

    public CommonException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
