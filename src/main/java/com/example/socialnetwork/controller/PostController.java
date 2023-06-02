package com.example.socialnetwork.controller;

import com.example.socialnetwork.dto.PostDTO;
import com.example.socialnetwork.model.Post;
import com.example.socialnetwork.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/posts")

public class PostController {
    private PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }
    public ResponseEntity<PostDTO> createPsot(
            @RequestBody PostDTO postDTO
    ){
        return new ResponseEntity<>(
                postService.createPost(postDTO),
                HttpStatus.CREATED
        );
    }
}