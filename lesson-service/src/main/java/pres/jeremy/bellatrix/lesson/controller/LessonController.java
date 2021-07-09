package pres.jeremy.bellatrix.lesson.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pres.jeremy.bellatrix.common.web.dto.UserDTO;
import pres.jeremy.bellatrix.common.web.support.EnableControllerLog;
import pres.jeremy.bellatrix.common.web.support.Result;
import pres.jeremy.bellatrix.common.web.utils.RequestUtil;
import pres.jeremy.bellatrix.lesson.api.LessonFeign;
import pres.jeremy.bellatrix.user.api.UserFeign;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@EnableControllerLog
public class LessonController implements LessonFeign {

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private ConfigService configService;

    @Override
    @ApiOperation(value = "获取用户", response = UserDTO.class)
    public Result<UserDTO> getUser(@RequestParam("id") Long id) {
        log.info("request: 【{}】", RequestUtil.getRequest());
        return userFeign.getUser(id);
    }

    @Override
    public Result<String> push() throws NacosException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangjun");
        map.put("age", 28);
        configService.publishConfig("zj123", "lesson-group", JSONObject.toJSONString(map));
        return Result.ok("success");
    }


}
