package pres.jeremy.bellatrix.oauth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.jeremy.bellatrix.common.web.dto.UserDTO;
import pres.jeremy.bellatrix.common.web.support.Result;
import pres.jeremy.bellatrix.oauth.config.JwtConfig;
import pres.jeremy.bellatrix.oauth.service.IOauthService;
import pres.jeremy.bellatrix.user.api.UserFeign;
import pres.jeremy.bellatrix.user.query.LoginParam;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class OauthServiceImpl implements IOauthService {

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public UserDTO doLogin(LoginParam loginParam, HttpServletResponse response) {
        Result<UserDTO> result = userFeign.login(loginParam);
        UserDTO userDTO = result.getData();
        Map<String, Object> claim = new HashMap<>();
        claim.put("user_id", userDTO.getId());
        claim.put("user_name", userDTO.getUserName());
        claim.put("name", userDTO.getName());
        String jwt = jwtConfig.createJWT(claim, "bellatrix");
        response.setHeader("Authorization", jwt);
        return userDTO;
    }
}
