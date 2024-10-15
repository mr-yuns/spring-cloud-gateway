package com.spring_cloud_gateway.filter;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RequestResponseFilter extends AbstractGatewayFilterFactory<RequestResponseFilter.Config> {
    public RequestResponseFilter () {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply (RequestResponseFilter.Config config) {
        // 서비스 서버에 요청 전
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // 서비스 서버에서 응답 후
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {

            }));
        });
    }

    @Data
    public static class Config {
        private String baseMessage;
        private boolean requestLogger;
        private boolean responseLogger;
    }
}