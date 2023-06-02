package com.example.socialnetwork.repository;

import com.example.socialnetwork.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository
        extends JpaRepository<Post, Long> {
}
