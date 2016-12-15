package com.github.codingricky;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Consumer {
    private final String url;
    private final RestTemplate restTemplate;

    public Consumer(final String url) {
        this.url = url;
        this.restTemplate = new RestTemplate();
    }

    public String get(Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response =
                restTemplate.exchange(url + "/customer/{id}", HttpMethod.GET, entity, String.class, id);
        return response.getBody();
    }
}
