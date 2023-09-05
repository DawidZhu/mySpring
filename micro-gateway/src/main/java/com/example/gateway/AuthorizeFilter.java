package com.example.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * GlobalFilter
 *
 * 自定义 Gateway Filter的全局过滤器 GlobalFilter
 * 对所有路由都生效的过滤器，并且可以自定义处理 逻辑
 * Spring 提供31种 Gateway Filter Factories: AddRequestHeader, AddRequestParameter...
 *
 * http://127.0.0.1:10010/user/1?name=David
 * http://127.0.0.1:10010/order/101?name=David
 */
 @Order(-1)
 @Component //注入到Spring Bean
public class AuthorizeFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1。获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();
        //2.获取指定的参数
        String name = params.getFirst("name");
        //3。判断参数值是否等于 david
        if("David".equals(name)){
            //4. 放行
          return  chain.filter(exchange);
        }
        //5.拦截, 设置状态码，(401, "Unauthorized"),
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }
}
