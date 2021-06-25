package pres.jeremy.bellatrix.lesson.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.jeremy.bellatrix.user.api.UserFeign;

@RestController
@Api(description = "测试课程", tags = "LessonController")
public class LessonController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户", response = String.class)
    public String getUser() {
        return userFeign.demo();
    }
}
