package com.example.socialnetwork.service;

import com.example.socialnetwork.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getPosts();
    PostDTO getPostById(Long id);
}
