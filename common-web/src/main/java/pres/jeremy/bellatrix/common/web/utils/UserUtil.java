package pres.jeremy.bellatrix.common.web.utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pres.jeremy.bellatrix.common.web.constant.BaseConstant;
import pres.jeremy.bellatrix.common.web.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserUtil {


    public static final HttpServletRequest getCurrentRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getRequest();
        }
        return null;
    }

    public static final HttpServletResponse getCurrentResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getResponse();
        }
        return null;
    }

    public static String getHeadValue(String key) {
        return getCurrentRequest().getHeader(key);
    }

    public static UserDTO getUser() {
        HttpServletRequest request = getCurrentRequest();
        if (request == null) {
            return null;
        }
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        return user;
    }

    public static Long getUserId() {
        UserDTO user = getUser();
        if (user == null) {
            return null;
        }
        return user.getId();
    }

    public static final String getCurrentLanguage() {
        HttpServletRequest request = getCurrentRequest();
        if (request == null) {
            return BaseConstant.DEFAULT_LANGUAGE;
        }
        String language = request.getHeader("language");
        if (StringUtils.isEmpty(language)) {
            language = BaseConstant.DEFAULT_LANGUAGE;
        }
        return language;
    }
}
