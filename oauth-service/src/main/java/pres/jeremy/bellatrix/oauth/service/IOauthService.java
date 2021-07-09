package pres.jeremy.bellatrix.oauth.service;

import pres.jeremy.bellatrix.common.web.dto.UserDTO;
import pres.jeremy.bellatrix.user.query.LoginParam;

import javax.servlet.http.HttpServletResponse;

public interface IOauthService {

    UserDTO doLogin(LoginParam loginParam, HttpServletResponse response);
}
