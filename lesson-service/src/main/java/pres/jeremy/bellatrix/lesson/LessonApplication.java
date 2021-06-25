package pres.jeremy.bellatrix.lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"pres.jeremy.bellatrix.*.api"})
public class LessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessonApplication.class, args);
    }
}
