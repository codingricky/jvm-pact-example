package com.github.codingricky;

import au.com.dius.pact.consumer.ConsumerPactTest;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ConsumerTest extends ConsumerPactTest {

    @Override
    protected PactFragment createFragment(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return builder
                .given("testState")
                .uponReceiving("ExampleJavaConsumerPactTest test interaction")
                .path("/customer/123")
                .method("GET")
                .headers(headers)
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("{\"name\": \"harry\"}")
                .toFragment();
    }

    @Override
    protected String providerName() {
        return "testProvider";
    }

    @Override
    protected String consumerName() {
        return "testConsumer";
    }

    @Override
    protected void runTest(String url) throws IOException {
        assertEquals(new Consumer(url).get(123), "{\"name\": \"harry\"}");
    }
}
