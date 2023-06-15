package com.example.socialnetwork.service.serviceimpl;

import com.example.socialnetwork.dto.PostDTO;
import com.example.socialnetwork.exception.ResourceNotFoundException;
import com.example.socialnetwork.model.Post;
import com.example.socialnetwork.repository.PostRepository;
import com.example.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    @Autowired
    PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDto) {

        // convert DTO to entity
        Post post = mapToModel(postDto);
        Post newPost = post;
        postRepository.save(post);

        // convert entity to DTO
        PostDTO postResponse = mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public List<PostDTO> getPosts() {
        List<PostDTO> postDtos = postRepository
                .findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostDTO getPostById(Long id) {
        System.out.println("getPostById");
        return postRepository
                .findAll()
                .stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .map(this::mapToDTO)
                .orElse(new PostDTO());
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id.toString()));
        if(post == null) {
            new IllegalArgumentException("User not found " + id);
        }
        post.setId(postDTO.getId());
        post.setTitle(post.getTitle());
        post.setContent(post.getContent());
        post.setDescription(postDTO.getDescription());
        return mapToDTO(postRepository.save(post));
    }

    private PostDTO mapToDTO(Post post){
        var postDto = new PostDTO();
//        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    private Post mapToModel(PostDTO postDTO){
        Post post = new Post();
//        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        return post;
    }
}
