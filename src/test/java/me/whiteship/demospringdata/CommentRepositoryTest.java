package me.whiteship.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    Hosuk hosuk;

    @Test
    public void crud(){
        createComment(100, "spring data jpa");
        createComment(50, "hibernate SPRING");
        createComment(20, "test spring");
        createComment(10, "test spring2");


        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("Spring", 1);
        assertThat(comments.size()).isEqualTo(4);

        List<Comment> comments1 = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("Spring");
        assertThat(comments1).first().hasFieldOrPropertyWithValue("likeCount", 100);

        List<Comment> comment2 = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountAsc("SPRING");
        assertThat(comment2.size()).isEqualTo(4);
        assertThat(comment2).first().hasFieldOrPropertyWithValue("likeCount", 10);


        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));
        Page<Comment> commentPage = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);
        assertThat(commentPage.getNumberOfElements()).isEqualTo(4);
        assertThat(commentPage).first().hasFieldOrPropertyWithValue("likeCount", 100);

        try( Stream<Comment> commentStream = commentRepository.findByCommentContainsIgnoreCase("spring") ) {
            Comment comment = commentStream.findFirst().get();
            assertThat(comment.getLikeCount()).isEqualTo(100);
        }

    }

    private void createComment(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setLikeCount(likeCount);
        newComment.setComment(comment);
        commentRepository.save(newComment);
    }

}