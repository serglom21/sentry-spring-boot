package com.example.demo;

import com.example.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {

    private final RestTemplate restTemplate;

    public ApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello")
    public String hello() {
//		RestTemplate restTemplate = new RestTemplate();

        String URI = "http://localhost:8082/health-check";

        ResponseEntity<?> result = restTemplate.getForEntity(URI, Response.class);

        return String.format(result.getBody().toString());
    }
}
