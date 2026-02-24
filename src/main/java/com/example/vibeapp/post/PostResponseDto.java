package com.example.vibeapp.post;

import java.time.LocalDateTime;

public record PostResponseDto(
    Long no,
    String title,
    String content,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    Integer views,
    String tags
) {
    public PostResponseDto() {
        this(null, null, null, null, null, null, null);
    }

    public static PostResponseDto from(Post post, String tags) {
        if (post == null) return null;
        return new PostResponseDto(
                post.getNo(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getViews(),
                tags
        );
    }
}
