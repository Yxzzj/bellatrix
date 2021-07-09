package pres.jeremy.bellatrix.oauth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.jeremy.bellatrix.common.web.dto.UserDTO;
import pres.jeremy.bellatrix.common.web.support.EnableControllerLog;
import pres.jeremy.bellatrix.common.web.support.Result;
import pres.jeremy.bellatrix.common.web.utils.BeanUtil;
import pres.jeremy.bellatrix.oauth.enums.ResultCode;
import pres.jeremy.bellatrix.oauth.service.IOauthService;
import pres.jeremy.bellatrix.user.query.LoginParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@EnableControllerLog
@RestController
@RequestMapping("/api/oauth")
@Api(description = "认证管理", tags = "OauthController")
public class OauthController {

    @Autowired
    private IOauthService oauthService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", response = UserDTO.class)
    public Result<UserDTO> saveUser(@RequestBody @Valid LoginParam loginParam, HttpServletResponse response){
        return Result.restResult(BeanUtil.clone(oauthService.doLogin(loginParam, response), UserDTO.class), ResultCode.OPERATE_SUCCESS);
    }
}
