package com.fervidsmart.servicegateway.service;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Function;

public interface ServiceNowIntegration {
    <T> T execute(Function<WebClient, T> operation);
}
