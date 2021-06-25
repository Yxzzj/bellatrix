package pres.jeremy.bellatrix.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pres.jeremy.bellatrix.common.util.support.EnableControllerLog;
import pres.jeremy.bellatrix.common.util.support.Result;
import pres.jeremy.bellatrix.common.util.utils.BeanUtil;
import pres.jeremy.bellatrix.user.dto.UserDTO;
import pres.jeremy.bellatrix.user.enums.ResultCode;
import pres.jeremy.bellatrix.user.query.SaveUserParam;
import pres.jeremy.bellatrix.user.service.IUserService;

import javax.validation.Valid;

@EnableControllerLog
@RestController
@Api(description = "用户管理", tags = "UserController")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/saveUser")
    @ApiOperation(value = "添加用户", response = Boolean.class)
    public Result<Boolean> saveUser(@RequestBody @Valid SaveUserParam saveUserParam) {
        return Result.restResult(userService.saveUser(saveUserParam), ResultCode.OPERATE_SUCCESS);
    }

    public Result<UserDTO> getUser(@RequestParam("id") Long id) {
        return Result.restResult(BeanUtil.clone(userService.getById(id), UserDTO.class), ResultCode.OPERATE_SUCCESS);
    }
}
