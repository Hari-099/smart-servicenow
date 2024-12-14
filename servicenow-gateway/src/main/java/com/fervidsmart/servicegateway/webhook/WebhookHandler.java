package com.fervidsmart.servicegateway.webhook;

import java.util.Map;

public class WebhookHandler {
    public void handleEvent(Map<String, Object> eventPayload) {
        // Handle webhook events with business logic encapsulated here
        System.out.println("Received webhook event: " + eventPayload);
    }
}
