package com.example.vibeapp.post;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PostRepository {
    List<Post> findAll();
    
    // 페이징 처리를 위한 SQL 매퍼 전용 메서드 (필요시 사용)
    List<Post> findAllWithPaging(@Param("offset") int offset, @Param("limit") int limit);
    
    Post findById(Long no);
    
    void save(Post post);
    
    void update(Post post);
    
    void delete(Long no);
    
    void increaseViews(Long no);
    
    int count();
}
