package me.whiteship.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.rmi.StubNotFoundException;
import java.util.HashSet;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Post post = new Post();
//        post.setTitle("Spring Data JPA");
//
//        Comment comment = new Comment();
//        comment.setComment("댓글 설리");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("댓글 설리2");
//        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
//        session.save(post);

        Post post = session.load(Post.class, 1L);
        session.delete(post);

    }
}
