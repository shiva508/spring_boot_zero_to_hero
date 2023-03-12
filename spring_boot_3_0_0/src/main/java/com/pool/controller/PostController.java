package com.pool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.model.Post;
import com.pool.repository.PostRepository;
import com.pool.service.JsonPlaceHolderService;
import com.pool.service.PostService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;

    private final JsonPlaceHolderService holderService;

    public PostController(PostRepository postRepository, PostService postService,
            JsonPlaceHolderService holderService) {
        this.postRepository = postRepository;
        this.postService = postService;
        this.holderService = holderService;
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/postsfrom")
    public List<Post> postsFromApi() {
        return postService.saveAllPosts();
    }

    @GetMapping("/postsusinghttp")
    public Flux<Post> postsUsingHttpInterface() {
        return holderService.loadPosts();
    }

    @GetMapping("postsusinghttp/{postId}")
    public Mono<Post> postById(@PathVariable("postId") Integer postId) {
        return holderService.postById(postId);
    }
}
