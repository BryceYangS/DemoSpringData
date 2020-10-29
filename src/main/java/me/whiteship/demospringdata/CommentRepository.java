package me.whiteship.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long>{

//    @Query(value = "SELECT *  FROM Comment AS c", nativeQuery = true)
    List<Comment> findByCommentContains(String keyword);

    // Pageable 내 Sort가 이미 있기 때문에 Pageable에서 미리 세팅 가능함
    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

    // OrderBy처럼 정렬을 하고 싶을 경우 Sort
    List<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Sort sort);
}
