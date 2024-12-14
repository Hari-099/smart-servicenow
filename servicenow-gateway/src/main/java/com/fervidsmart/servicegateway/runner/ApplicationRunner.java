package com.fervidsmart.servicegateway.runner;

import com.fervidsmart.servicegateway.service.ServiceNowIntegration;

import java.util.HashMap;
import java.util.Map;

public class ApplicationRunner {
    private final ServiceNowIntegration serviceNowIntegration;

    public ApplicationRunner(ServiceNowIntegration serviceNowIntegration) {
        this.serviceNowIntegration = serviceNowIntegration;
    }

    public void run() {
        String endpoint = "/table/incident";
        Map<String, Object> newIncident = new HashMap<>();
        newIncident.put("short_description", "Example incident created via REST API");
        newIncident.put("urgency", "2");

        Map<String, Object> response = serviceNowIntegration.execute(client ->
                client.post()
                        .uri(endpoint)
                        .bodyValue(newIncident)
                        .retrieve()
                        .bodyToMono(Map.class)
                        .block());

        System.out.println("Incident created: " + response);
    }
}
