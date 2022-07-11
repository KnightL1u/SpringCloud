//package com.lzw.springcloud.config;//@date :2022/7/8 13:19
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayConfig {
//
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        routes.route("route01",
//                r -> r.path("/lb")
//                        .uri("http://localhost:8001/payment/lb")).build();
//        //当访问localhost:9527/java时,将跳转至该链接
//        return routes.build();
//    }
//}
