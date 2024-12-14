package com.fervidsmart.servicegateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ServicenowGatewayApplication {

    @Value("${servicenow.base-url}")
    private String serviceNowBaseUrl;

    @Value("${servicenow.token}")
    private String serviceNowToken;

    public static void main(String[] args) {
        SpringApplication.run(ServicenowGatewayApplication.class, args);
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(serviceNowBaseUrl)
                .defaultHeader("Authorization", "Bearer " + serviceNowToken)
                .build();
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("servicenow_rest", r -> r.path("/api/servicenow/**")
                        .filters(f -> f.rewritePath("/api/servicenow/(?<segment>.*)", "/api/now/${segment}"))
                        .uri(serviceNowBaseUrl))
                .route("servicenow_webhook", r -> r.path("/webhook/**")
                        .uri(serviceNowBaseUrl + "/api/webhook"))
                .build();
    }

}
