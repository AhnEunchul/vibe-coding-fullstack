package com.example.vibeapp.post;

import java.time.LocalDateTime;

public record PostListDto(
    Long no,
    String title,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    Integer views
) {
    public PostListDto() {
        this(null, null, null, null, null);
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
}
