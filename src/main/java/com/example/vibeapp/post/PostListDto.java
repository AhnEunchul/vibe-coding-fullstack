package com.example.vibeapp.post;

import java.time.LocalDateTime;

public class PostListDto {
    private Long no;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer views;

    public PostListDto() {}

    public PostListDto(Long no, String title, LocalDateTime createdAt, LocalDateTime updatedAt, Integer views) {
        this.no = no;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.views = views;
    }

    public static PostListDto from(Post post) {
        if (post == null) return null;
        return new PostListDto(
                post.getNo(),
                post.getTitle(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getViews()
        );
    }

    public Long getNo() { return no; }
    public String getTitle() { return title; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public Integer getViews() { return views; }
}
