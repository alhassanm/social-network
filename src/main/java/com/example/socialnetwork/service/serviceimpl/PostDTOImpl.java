package com.example.socialnetwork.service.serviceimpl;

import com.example.socialnetwork.dto.PostDTO;
import com.example.socialnetwork.model.Post;
import com.example.socialnetwork.repository.PostRepository;
import com.example.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDTOImpl implements PostService {
    private PostRepository postRepository;
    @Autowired
    PostDTOImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(post.getContent());
        Post newPost = postRepository.save(post);

        PostDTO postResp = new PostDTO();
        postResp.setId(newPost.getId());
        postResp.setTitle(newPost.getTitle());
        postResp.setDescription(newPost.getDescription());
        postResp.setContent(newPost.getContent());

        return postResp;
    }
}
