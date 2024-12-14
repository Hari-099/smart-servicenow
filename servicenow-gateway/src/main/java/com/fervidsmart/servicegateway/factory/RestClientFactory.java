package com.fervidsmart.servicegateway.factory;

import com.fervidsmart.servicegateway.service.ServiceNowIntegration;
import com.fervidsmart.servicegateway.service.ServiceNowRestClient;
import org.springframework.web.reactive.function.client.WebClient;

public class RestClientFactory extends ServiceNowClientFactory{
    public RestClientFactory(WebClient webClient) {
        super(webClient);
    }

    @Override
    public ServiceNowIntegration createClient() {
        return new ServiceNowRestClient(webClient);
    }
}
