package pres.jeremy.bellatrix.user.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pres.jeremy.bellatrix.common.web.dto.UserDTO;
import pres.jeremy.bellatrix.common.web.support.EnableControllerLog;
import pres.jeremy.bellatrix.common.web.support.Result;
import pres.jeremy.bellatrix.common.web.utils.BeanUtil;
import pres.jeremy.bellatrix.common.web.utils.RequestUtil;
import pres.jeremy.bellatrix.user.api.UserFeign;
import pres.jeremy.bellatrix.user.enums.ResultCode;
import pres.jeremy.bellatrix.user.query.LoginParam;
import pres.jeremy.bellatrix.user.query.SaveUserParam;
import pres.jeremy.bellatrix.user.service.IUserService;

import javax.validation.Valid;

@Slf4j
@EnableControllerLog
@RestController
public class UserController implements UserFeign {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "添加用户", response = Boolean.class)
    public Result<Boolean> saveUser(@RequestBody @Valid SaveUserParam saveUserParam) {
        return Result.restResult(userService.saveUser(saveUserParam), ResultCode.OPERATE_SUCCESS);
    }

//    @SentinelResource(value = "SentinelTestException", fallback = "SentinelTestException")
    @ApiOperation(value = "获取用户", response = UserDTO.class)
    public Result<UserDTO> getUser(@RequestParam("id") Long id) {
        log.info("request: 【{}】", RequestUtil.getRequest());
        return Result.restResult(BeanUtil.clone(userService.getById(id), UserDTO.class), ResultCode.OPERATE_SUCCESS);
    }

    @ApiOperation(value = "登录", response = UserDTO.class)
    public Result<UserDTO> login(@RequestBody @Valid LoginParam loginParam) {
        return Result.restResult(BeanUtil.clone(userService.login(loginParam), UserDTO.class), ResultCode.OPERATE_SUCCESS);
    }

    public Result<UserDTO> SentinelTestException (Long id) {
        log.error ("id={}",id);
        return Result.restResult(new UserDTO(), ResultCode.OPERATE_FAILED);
    }
}
