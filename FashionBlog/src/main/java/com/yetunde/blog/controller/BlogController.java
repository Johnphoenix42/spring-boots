package com.yetunde.blog.controller;

import com.yetunde.blog.model.Post;
import com.yetunde.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class BlogController {

    private final PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Home page showing all fashion posts
    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index"; // looks for src/main/resources/templates/index.html
    }

    // Individual post page
    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String formattedDate = post.getCreatedAt().format(formatter);

        model.addAttribute("formattedDate", formattedDate);
        model.addAttribute("post", post);
        return "post-detail"; // looks for src/main/resources/templates/post-detail.html
    }
}
