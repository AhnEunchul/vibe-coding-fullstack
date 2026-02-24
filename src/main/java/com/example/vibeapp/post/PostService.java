package com.example.vibeapp.post;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostTagRepository postTagRepository;

    public PostService(PostRepository postRepository, PostTagRepository postTagRepository) {
        this.postRepository = postRepository;
        this.postTagRepository = postTagRepository;
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
        Post post = postRepository.findById(no);
        if (post == null) return null;
        
        List<PostTag> tags = postTagRepository.findByPostNo(no);
        String tagsString = String.join(", ", tags.stream().map(PostTag::getTagName).toList());
        
        return PostResponseDto.from(post, tagsString);
    }

    @Transactional
    public void createPost(PostCreateDto createDto) {
        Post post = createDto.toEntity();
        postRepository.save(post);
        saveTags(post.getNo(), createDto.tags());
    }

    @Transactional
    public void updatePost(Long no, PostUpdateDto updateDto) {
        Post post = postRepository.findById(no);
        if (post != null) {
            post.setTitle(updateDto.title());
            post.setContent(updateDto.content());
            post.setUpdatedAt(java.time.LocalDateTime.now());
            postRepository.update(post);
            
            postTagRepository.deleteByPostNo(no);
            saveTags(no, updateDto.tags());
        }
    }

    private void saveTags(Long postNo, String tagsString) {
        if (tagsString == null || tagsString.isBlank()) return;
        
        String[] tags = tagsString.split(",");
        for (String tagName : tags) {
            String trimmedTag = tagName.trim();
            if (!trimmedTag.isEmpty()) {
                PostTag postTag = new PostTag();
                postTag.setPostNo(postNo);
                postTag.setTagName(trimmedTag);
                postTag.setId(null); // Ensure ID is null for auto-increment
                postTagRepository.save(postTag);
            }
        }
    }

    public void deletePost(Long no) {
        postRepository.delete(no);
    }
}
