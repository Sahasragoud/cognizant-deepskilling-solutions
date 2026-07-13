package com.cognizant.api_gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;

@Component
public class LogFilter implements GlobalFilter, Ordered {

    Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        logger.info("Incoming Request : {} {}",
                exchange.getRequest().getMethod(),
                exchange.getRequest().getURI());

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}