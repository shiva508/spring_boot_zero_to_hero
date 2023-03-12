package com.pool.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import com.pool.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JsonPlaceHolderService {

    @GetExchange("/posts")
    public Flux<Post> loadPosts();

    @GetExchange("/posts/{postId}")
    public Mono<Post> postById(@PathVariable("postId") Integer postId);
}
