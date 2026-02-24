package com.example.vibeapp.repository;

import com.example.vibeapp.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();

    public PostRepository() {
        // Initialize with 10 dummy records
        for (long i = 1; i <= 10; i++) {
            LocalDateTime createdAt = LocalDateTime.now().minusDays(10 - i);
            LocalDateTime updatedAt = (i % 3 == 0) ? createdAt.plusHours(i) : createdAt;
            posts.add(new Post(
                i,
                "테스트 게시글 제목 " + i,
                "이것은 " + i + "번째 게시글의 내용입니다. 안녕하세요!",
                createdAt,
                updatedAt,
                (int) (Math.random() * 100)
            ));
        }
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }

    public Post findByNo(Long no) {
        return posts.stream()
                .filter(post -> post.getNo().equals(no))
                .findFirst()
                .orElse(null);
    }

    public void save(Post post) {
        if (post.getNo() == null) {
            long nextNo = posts.stream()
                    .mapToLong(Post::getNo)
                    .max()
                    .orElse(0L) + 1;
            post.setNo(nextNo);
        }
        posts.add(post);
    }

    public void delete(Long no) {
        posts.removeIf(post -> post.getNo().equals(no));
    }
}
