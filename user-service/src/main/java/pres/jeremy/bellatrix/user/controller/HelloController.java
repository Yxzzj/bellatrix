package pres.jeremy.bellatrix.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import pres.jeremy.bellatrix.user.api.UserFeign;

@RestController
public class HelloController implements UserFeign {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    public String demo() {
        return "hello " + applicationName + ",port: " + port;
    }
}
