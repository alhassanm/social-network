package com.example.socialnetwork.service;

import com.example.socialnetwork.dto.PostDTO;
import org.springframework.stereotype.Service;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
}
