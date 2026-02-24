package com.example.vibeapp.post;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PostMapper {
    List<PostListDto> findAll(@Param("offset") int offset, @Param("limit") int limit);
    PostResponseDto findById(Long no);
    void save(PostCreateDto post);
    void update(PostUpdateDto post);
    void delete(Long no);
    int count();
}
