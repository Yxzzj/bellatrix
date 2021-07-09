package pres.jeremy.bellatrix.common.web.utils;

import cn.hutool.core.collection.IterUtil;
import pres.jeremy.bellatrix.common.web.exception.BusinessException;
import pres.jeremy.bellatrix.common.web.support.IMessageCode;

public class ExceptionUtil extends cn.hutool.core.exceptions.ExceptionUtil {

    /**
     * Exception.
     *
     * @param msgCodeEnum the msg code enum
     */
    public static void throwException(IMessageCode msgCodeEnum) {
        throw new BusinessException(msgCodeEnum);
    }

    /**
     * Throw exception.
     *
     * @param msg the msg
     */
    public static void throwException(String msg) {
        throw new BusinessException(-1, msg);
    }

    /**
     * 检查异常语法糖
     *
     * @param result      the result
     * @param msgCodeEnum the msg code enum
     * @return the boolean
     */
    public static Boolean checkException(Boolean result, IMessageCode msgCodeEnum) {
        if (result == null || !result) {
            throw new BusinessException(msgCodeEnum);
        }
        return result;
    }

    /**
     * 检查异常语法糖
     *
     * @param object      the object
     * @param msgCodeEnum the msg code enum
     * @return the object
     */
    public static Object checkException(Object object, IMessageCode msgCodeEnum) {
        if (object == null) {
            throw new BusinessException(msgCodeEnum);
        }
        return object;
    }

    /**
     * 检查集合异常语法糖
     *
     * @param iterable    the iterable
     * @param msgCodeEnum the msg code enum
     * @return the boolean
     */
    public static Iterable checkIterableException(Iterable iterable, IMessageCode msgCodeEnum) {
        if (IterUtil.isEmpty(iterable)) {
            throw new BusinessException(msgCodeEnum);
        }
        return iterable;
    }
}
