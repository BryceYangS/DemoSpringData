package me.whiteship.demospringdata;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Post add(Post post){
        entityManager.persist(post);
        return post;
    }

    public void deletePost(Post post){
        entityManager.remove(post);
    }

    public List<Post> findAll(){
        return entityManager.createQuery("SELECT p FROM Post AS p", Post.class).getResultList();
    }

}