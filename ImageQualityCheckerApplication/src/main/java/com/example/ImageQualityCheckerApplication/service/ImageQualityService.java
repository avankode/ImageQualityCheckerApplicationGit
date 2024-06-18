package com.example.ImageQualityCheckerApplication.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Service
public class ImageQualityService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String evaluateImageQuality(String imageUrl) {
        String pythonApiUrl = "http://localhost:5000/evaluate";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestJson = "{\"imageUrl\": \"" + imageUrl + "\"}";
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(pythonApiUrl, entity, String.class);
        return response.getBody();
    }
}