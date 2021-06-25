package pres.jeremy.bellatrix.common.util.exception;

public abstract class BaseException extends RuntimeException {

    protected int code;

    protected String message;

    public BaseException() {
    }

    public BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(String message, Throwable ex) {
        super(message, ex);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
