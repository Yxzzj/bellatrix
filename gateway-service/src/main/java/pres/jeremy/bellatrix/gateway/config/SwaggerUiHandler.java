package pres.jeremy.bellatrix.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

import java.util.Optional;

/**
  * 提供Swagger3 UI层配置数据  http://localhost:9000/swagger-resources/configuration/ui
  * @author Zhang Jun
  * @date 2021-06-30 15:23
 */
@Slf4j
@Component
public class SwaggerUiHandler implements HandlerFunction<ServerResponse> {

    @Autowired(required = false)
    private UiConfiguration uiConfiguration;

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(BodyInserters
                .fromValue(Optional.ofNullable(uiConfiguration).orElse(UiConfigurationBuilder.builder().build())));
    }

}
