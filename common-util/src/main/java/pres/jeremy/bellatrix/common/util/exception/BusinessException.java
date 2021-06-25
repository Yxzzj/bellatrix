package pres.jeremy.bellatrix.common.util.exception;

import pres.jeremy.bellatrix.common.util.support.IMessageCode;

public class BusinessException extends BaseException {

    public BusinessException() {
    }

    public BusinessException(String message) {
        this.code = -1;
        this.message = message;
    }

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(IMessageCode messageCode) {
        super(messageCode.code(), messageCode.message());
    }

    public BusinessException(String message, Throwable ex) {
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