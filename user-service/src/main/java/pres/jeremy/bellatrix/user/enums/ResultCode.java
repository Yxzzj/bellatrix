package pres.jeremy.bellatrix.user.enums;

import pres.jeremy.bellatrix.common.web.support.IMessageCode;
import pres.jeremy.bellatrix.common.web.support.Resources;
import pres.jeremy.bellatrix.common.web.utils.UserUtil;

public enum ResultCode implements IMessageCode {

    OPERATE_SUCCESS(1, "OPERATE_SUCCESS"),

    OPERATE_FAILED(-1, "OPERATE_FAILED"),

    USER_NAME_NOT_EXISTS(-1, "USER_NAME_NOT_EXISTS"),

    PASSWORD_ERROR(-1, "PASSWORD_ERROR"),

    /**
     * 暂无数据
     */
    NO_DATA(-1, "NO_DATA"),

    NO_LOGIN(401, "NO_LOGIN"),

    KICKED_OUT(402, "KICKED_OUT");

    private int code;
    private String msg;

    ResultCode() {
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }

    @Override
    public String message() {
        return Resources.getMessage(this.msg(), UserUtil.getCurrentLanguage());
    }
}
