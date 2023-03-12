package com.pool.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.pool.model.Post;

public interface PostRepository extends ListCrudRepository<Post, Integer> {

}
