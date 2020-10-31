package me.whiteship.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;
import java.util.stream.Stream;

@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long>{

//    List<Comment> findByCommentContainsIgnoreCase(String keyword);
    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan (String keyword, int likeCount);
    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc (String keyword);
    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountAsc (String keyword);
    Page<Comment> findByCommentContainsIgnoreCase (String keyword, Pageable pageable);

    Stream<Comment> findByCommentContainsIgnoreCase (String keyword);

}
