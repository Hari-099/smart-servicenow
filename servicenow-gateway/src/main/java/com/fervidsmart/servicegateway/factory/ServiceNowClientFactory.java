package com.fervidsmart.servicegateway.factory;

import com.fervidsmart.servicegateway.service.ServiceNowIntegration;
import org.springframework.web.reactive.function.client.WebClient;

public abstract class ServiceNowClientFactory {
    protected WebClient webClient;

    public ServiceNowClientFactory(WebClient webClient) {
        this.webClient = webClient;
    }
    public abstract ServiceNowIntegration createClient();
}
