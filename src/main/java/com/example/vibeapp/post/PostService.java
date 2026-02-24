package com.example.vibeapp.post;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostListDto> getPosts(int page, int size) {
        int offset = (page - 1) * size;
        return postRepository.findAllWithPaging(offset, size).stream()
                .map(PostListDto::from)
                .toList();
    }

    public int getTotalCount() {
        return postRepository.count();
    }

    @Transactional
    public PostResponseDto findById(Long no) {
        postRepository.increaseViews(no);
        return PostResponseDto.from(postRepository.findById(no));
    }

    public void createPost(PostCreateDto createDto) {
        postRepository.save(createDto.toEntity());
    }

    @Transactional
    public void updatePost(Long no, PostUpdateDto updateDto) {
        Post post = postRepository.findById(no);
        if (post != null) {
            post.setTitle(updateDto.title());
            post.setContent(updateDto.content());
            post.setUpdatedAt(java.time.LocalDateTime.now());
            postRepository.update(post);
        }
    }

    public void deletePost(Long no) {
        postRepository.delete(no);
    }
}
