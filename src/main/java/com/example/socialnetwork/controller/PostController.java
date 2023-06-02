package com.example.socialnetwork.controller;

import com.example.socialnetwork.dto.PostDTO;
import com.example.socialnetwork.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/posts")

public class PostController {
    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDTO> createPost(
            @RequestBody PostDTO postDTO
    ){
        return new ResponseEntity<>(
                postService.createPost(postDTO),
                HttpStatus.CREATED
        );
    }
}