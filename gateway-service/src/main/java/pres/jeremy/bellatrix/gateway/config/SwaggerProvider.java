package pres.jeremy.bellatrix.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
  * 提供Swagger3 获取注册中心服务资源处理器
  * @author Zhang Jun
  * @date 2021-06-30 15:25
 */
@Slf4j
@Primary
@Component
public class SwaggerProvider implements SwaggerResourcesProvider {
    private static final String API_URI = "/v3/api-docs";

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Autowired
    private GatewayProperties gatewayProperties;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        Set<String> dealed = new HashSet<>();// 记录已经添加过的server
        gatewayProperties.getRoutes().stream()
                .filter(routeDefinition -> !swaggerProperties.getIgnoreProviders().contains(routeDefinition.getUri().getHost()))
                .forEach(routeDefinition -> {
                            String url = "/" + routeDefinition.getUri().getHost().toLowerCase().split("-")[0] + API_URI;// 拼接url
                    System.out.println(url);
                            if (!dealed.contains(url)) {
                                dealed.add(url);
                                SwaggerResource swaggerResource = new SwaggerResource();
                                swaggerResource.setUrl(url);///设置服务文档user/v3/api-docs
                                swaggerResource.setName(routeDefinition.getUri().getHost());//设置服务名user
                                swaggerResource.setSwaggerVersion("3.0");
                                resources.add(swaggerResource);
                            }
                        }
                );
        return resources;
    }
}
