package pres.jeremy.bellatrix.lesson.api;

import com.alibaba.nacos.api.exception.NacosException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pres.jeremy.bellatrix.common.web.dto.UserDTO;
import pres.jeremy.bellatrix.common.web.support.Result;

@FeignClient(value = "lesson-service")
@Api(description = "课程管理", tags = "LessonController")
public interface LessonFeign {

    @GetMapping("/api/lesson/getUser")
    @ApiOperation(value = "获取用户", response = UserDTO.class)
    Result<UserDTO> getUser(@RequestParam("id") Long id);

    @GetMapping("/api/lesson/push")
    @ApiOperation(value = "推送测试", response = UserDTO.class)
    Result<String> push() throws NacosException;
}
