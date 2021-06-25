package pres.jeremy.bellatrix.common.util.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

public class MD5Util {

    public static String getMD5(String text) {
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }

    /**
     * 验证MD5
     * @param md5 被检MD5摘要字符串
     * @param text 原字符串
     * @return
     */
    public static Boolean md5Verify(String md5, String text) {
        if (StringUtils.isEmpty(md5) || StringUtils.isEmpty(text)) {
            return false;
        }
        String md5Text = getMD5(text);
        return StringUtils.equals(md5Text, md5);
    }
}
