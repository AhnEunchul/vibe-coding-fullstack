package com.example.vibeapp.post;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostListDto> getPosts(int page, int size) {
        List<Post> allPosts = postRepository.findAll().stream()
                .sorted((p1, p2) -> p2.getNo().compareTo(p1.getNo()))
                .toList();

        int fromIndex = (page - 1) * size;
        if (allPosts.size() <= fromIndex) {
            return List.of();
        }

        return allPosts.subList(fromIndex, Math.min(fromIndex + size, allPosts.size())).stream()
                .map(PostListDto::from)
                .toList();
    }

    public int getTotalCount() {
        return postRepository.findAll().size();
    }

    public PostResponseDto findById(Long no) {
        return PostResponseDto.from(postRepository.findById(no));
    }

    public void createPost(PostCreateDto createDto) {
        postRepository.save(createDto.toEntity());
    }

    public void updatePost(Long no, PostUpdateDto updateDto) {
        Post post = postRepository.findById(no);
        if (post != null) {
            post.setTitle(updateDto.getTitle());
            post.setContent(updateDto.getContent());
            post.setUpdatedAt(java.time.LocalDateTime.now());
        }
    }

    public void deletePost(Long no) {
        postRepository.delete(no);
    }
}
