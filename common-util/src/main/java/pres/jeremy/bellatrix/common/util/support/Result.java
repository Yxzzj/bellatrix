package pres.jeremy.bellatrix.common.util.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {

    private static long FAILED_CODE = -1;

    private static long SUCCESS_CODE = 1;

    private static String FAILED_MESSAGE = "OPERATE_FAILED";

    private static String SUCCESS_MESSAGE = "OPERATE_SUCCESS";

    /**
     * 业务错误码
     */
    private long code;
    /**
     * 结果集
     */
    private T data;
    /**
     * 描述
     */
    private String msg;

    public Result() {
    }

    public Result(IMessageCode messageCode) {
        if (messageCode == null) {
            this.code = FAILED_CODE;
            this.msg = FAILED_MESSAGE;
        } else {
            this.code = messageCode.code();
            this.msg = messageCode.msg();
        }
    }

    public static <T> Result<T> ok(T data) {
        return restResult(data, SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static <T> Result<T> failed(String message) {
        return restResult(null, -1, message);
    }

    public static <T> Result<T> failed(IMessageCode messageCode) {
        return restResult(null, messageCode);
    }

    public static <T> Result<T> restResult(T data, IMessageCode messageCode) {
        return restResult(data, messageCode.code(), messageCode.message());
    }

    public static <T> Result<T> restResult(IMessageCode messageCode) {
        return restResult(null, messageCode.code(), messageCode.message());
    }

    private static <T> Result<T> restResult(T data, long code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public boolean ok() {
        return SUCCESS_CODE == code;
    }
}
