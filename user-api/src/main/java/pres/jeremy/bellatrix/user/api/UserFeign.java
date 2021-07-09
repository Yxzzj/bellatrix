package pres.jeremy.bellatrix.user.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pres.jeremy.bellatrix.common.web.dto.UserDTO;
import pres.jeremy.bellatrix.common.web.support.Result;
import pres.jeremy.bellatrix.user.query.LoginParam;
import pres.jeremy.bellatrix.user.query.SaveUserParam;

import javax.validation.Valid;

@FeignClient(value = "user-service")
@Api(description = "用户管理", tags = "UserController")
public interface UserFeign {

    @PostMapping("/api/user/saveUser")
    @ApiOperation(value = "添加用户", response = Boolean.class)
    Result<Boolean> saveUser(@RequestBody @Valid SaveUserParam saveUserParam);

    @GetMapping("/api/user/getUser")
    @ApiOperation(value = "获取用户", response = UserDTO.class)
    Result<UserDTO> getUser(@RequestParam("id") Long id);

    @PostMapping("/api/user/login")
    @ApiOperation(value = "登录", response = UserDTO.class)
    Result<UserDTO> login(@RequestBody @Valid LoginParam loginParam);
}
