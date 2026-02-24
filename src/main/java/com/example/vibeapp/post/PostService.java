package com.example.vibeapp.post;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(int page, int size) {
        List<Post> allPosts = postRepository.findAll().stream()
                .sorted((p1, p2) -> p2.getNo().compareTo(p1.getNo()))
                .toList();

        int fromIndex = (page - 1) * size;
        if (allPosts.size() <= fromIndex) {
            return List.of();
        }

        return allPosts.subList(fromIndex, Math.min(fromIndex + size, allPosts.size()));
    }

    public int getTotalCount() {
        return postRepository.findAll().size();
    }

    public Post findById(Long no) {
        return postRepository.findById(no);
    }

    public void createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCreatedAt(java.time.LocalDateTime.now());
        post.setUpdatedAt(null);
        post.setViews(0);
        postRepository.save(post);
    }

    public void updatePost(Long no, String title, String content) {
        Post post = findById(no);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
            post.setUpdatedAt(java.time.LocalDateTime.now());
        }
    }

    public void deletePost(Long no) {
        postRepository.delete(no);
    }
}
