package com.example.socialnetwork.service.serviceimpl;

import com.example.socialnetwork.dto.PostDTO;
import com.example.socialnetwork.model.Post;
import com.example.socialnetwork.repository.PostRepository;
import com.example.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostDTOImpl implements PostService {
    private PostRepository postRepository;
    @Autowired
    PostDTOImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        var post = mapToModelPost(postDTO);
        Post newPost = postRepository.save(post);

        PostDTO postResp = mapToDto(newPost);
        return postResp;
    }

    @Override
    public List<PostDTO> getPosts() {
        List<PostDTO> postDtos = postRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostDTO getPostById(Long id) {
        return postRepository
                .findAll()
                .stream()
                .filter(post -> Objects.equals(post.getId(), id))
                .findFirst()
                .map(post -> mapToDto(post))
                .orElse(new PostDTO());
    }

    private PostDTO mapToDto(Post post){
        var postDto = new PostDTO();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    private Post mapToModelPost(PostDTO postDTO){
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(post.getContent());
        return post;
    }
}
