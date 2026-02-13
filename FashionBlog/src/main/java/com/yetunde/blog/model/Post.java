package com.yetunde.blog.model;

import jakarta.persistence.*;
/*import lombok.*;*/
import java.time.LocalDateTime;

@Entity
@Table( name = "posts")
/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content; // The full article

    private String summary; // Short teaser for the home page

    private String category; // e.g., "Vintage", "Streetwear", "Runway"

    private String author;

    private String imageUrl; // Path to your fashion photography

    private LocalDateTime createdAt;

    public Post(){}

    // Manual Constructor
    public Post(String title, String content, String summary, String category, String author, String imageUrl, LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.category = category;
        this.author = author;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /*@PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }*/
}
