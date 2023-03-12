package com.pool.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pool.model.Post;

@Service
public class PostService {

    private final RestTemplate restTemplate;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Post> saveAllPosts() {
        ResponseEntity<List<Post>> responseEntity = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/posts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>() {
                });
        return responseEntity.getBody();
    }
}
