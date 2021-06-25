package pres.jeremy.bellatrix.gateway.filter;

import cn.hutool.core.date.SystemClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@Slf4j
@Component
public class AccessFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        long now = SystemClock.now();
        ServerHttpRequest request = exchange.getRequest();
        String xPlatform = request.getHeaders().getFirst("x-platform");
        String methodValue = request.getMethodValue();
        URI uri = request.getURI();
        log.info("xplatform:{},method:{},url:{}", xPlatform, methodValue, uri);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
