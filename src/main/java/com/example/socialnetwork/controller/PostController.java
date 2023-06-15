package com.example.socialnetwork.controller;

import com.example.socialnetwork.dto.PostDTO;
import com.example.socialnetwork.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")

public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(
            @RequestBody PostDTO postDTO
    ) {
        return new ResponseEntity<>(
                postService.createPost(postDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("{postId}/post")
    public ResponseEntity<PostDTO> getPost(@PathVariable("postId") Long id) {
        System.out.println(id);
        return new ResponseEntity<>(
                postService.getPostById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getPosts() {
        System.out.println();
        return new ResponseEntity<>(
                postService.getPosts(),
                HttpStatus.OK
        );
    }

    @PutMapping("{id}/update")
    public ResponseEntity<PostDTO> updatePost(@PathVariable(name = "id") Long id,
                                              @RequestBody PostDTO postDTO) {
        PostDTO postResp = postService.updatePost(postDTO, id);
        return new ResponseEntity<>(postResp, HttpStatus.OK);
    }
}