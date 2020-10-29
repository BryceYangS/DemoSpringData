package me.whiteship.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

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
//        Optional<Comment> commnet = commentRepository.findById(100l);
//        assertThat(commnet).isEmpty();
//        commnet.isPresent();
//        Comment comment = commnet.orElse(new Comment());
//        commnet.orElseThrow(() -> new IllegalArgumentException());
//        commnet.orElseThrow(IllegalArgumentException::new); // -> method reference

        /*
            만약 Optional 사용하지 않으면 아래와 같이 Null 체크해야 함.
         */
//        Comment comment1 = commentRepository.findById(100l);
//        if (comment1 == null) {
//            throw new IllegalArgumentException();
//        }

//        List<Comment> comments = commentRepository.findAll();
//        assertThat(comments).isEmpty();

//        System.out.println("====================");
//        System.out.println(hosuk);
//
//
//        commentRepository.save(null);

//        commentRepository.findByLikeGreaterThanAndPost(null);
    }

}