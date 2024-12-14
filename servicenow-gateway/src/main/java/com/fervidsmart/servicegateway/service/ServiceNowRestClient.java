package com.fervidsmart.servicegateway.service;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Function;

public class ServiceNowRestClient implements ServiceNowIntegration {
    private final WebClient webClient;

    public ServiceNowRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public <T> T execute(Function<WebClient, T> operation) {
        return operation.apply(webClient);
    }

    public <T> T get(String endpoint, Class<T> responseType) {
        return execute(client -> client.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(responseType)
                .block());
    }

    public <T> T post(String endpoint, Object requestBody, Class<T> responseType) {
        return execute(client -> client.post()
                .uri(endpoint)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseType)
                .block());
    }
}
