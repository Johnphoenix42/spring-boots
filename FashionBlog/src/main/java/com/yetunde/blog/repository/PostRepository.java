package com.yetunde.blog.repository;

import com.yetunde.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Custom query to find posts by category for your navigation menu
    List<Post> findByCategoryOrderByCreatedAtDesc(String category);

}
