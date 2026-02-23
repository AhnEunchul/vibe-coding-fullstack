package com.example.vibeapp.service;

import com.example.vibeapp.model.Post;
import com.example.vibeapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll().stream()
                .sorted((p1, p2) -> p2.getNo().compareTo(p1.getNo()))
                .toList();
    }

    public Post getPost(Long no) {
        return postRepository.findByNo(no);
    }
}
