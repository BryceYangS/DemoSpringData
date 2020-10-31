package me.whiteship.demospringdata;

import com.sun.istack.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.list;

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

        commentRepository.flush();

        List<Comment> all = commentRepository.findAll();
        assertThat(all.size()).isEqualTo(4);

//        Future<List<Comment>> future = commentRepository.findByCommentContains("spring");
//        System.out.println("========");
//        System.out.println("========" + future.isDone());
//        List<Comment> comments = null; // 결과 나올 때 까지 기다림
//        try {
//            comments = future.get();
//            comments.forEach(System.out::println);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        ListenableFuture<List<Comment>> listListenableFuture = commentRepository.findByCommentContainsIgnoreCase("spring");
        System.out.println("========");
        System.out.println("========" + listListenableFuture.isDone());
        listListenableFuture.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable);
            }

            @Override
            public void onSuccess(@Nullable List<Comment> result) {
                System.out.println("=========== Async =============");
                result.forEach(System.out::println);
                System.out.println(result.size());
            }
        });

        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void createComment(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setLikeCount(likeCount);
        newComment.setComment(comment);
        commentRepository.save(newComment);
    }

}