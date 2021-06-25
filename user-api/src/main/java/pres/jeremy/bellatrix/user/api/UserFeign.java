package pres.jeremy.bellatrix.user.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value ="user-service")
@Api(description = "测试", tags = "UserController")
public interface UserFeign {

    @GetMapping("/demo")
    @ApiOperation(value = "测试demo", response = String.class)
    String demo();
}
