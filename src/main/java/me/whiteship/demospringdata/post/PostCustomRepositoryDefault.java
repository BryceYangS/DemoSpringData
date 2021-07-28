package me.whiteship.demospringdata.post;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
// 원래는 Impl 인 접두어가 붙어야 한다. Application.java 에서 접두어를 변경하여서 아래처럼 Default가 된 것이다.
public class PostCustomRepositoryDefault implements PostCustomRepository<Post>{

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Post> findMyPost() {
		System.out.println("==== findMyPost======");
		// JPQL 이라고 함
		return entityManager.createQuery("SELECT p FROM Post AS p", Post.class).getResultList();
	}

	@Override
	public void delete(Post entity) {
		System.out.println("custom delete");
		entityManager.remove(entity);
	}
}
