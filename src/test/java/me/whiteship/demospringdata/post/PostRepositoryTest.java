package me.whiteship.demospringdata.post;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;

	@Test
	public void crud() {
		Post post = new Post();
		post.setTitle("hibernate");
		postRepository.save(post);

		postRepository.findMyPost();

		// 테스트라 다시 롤백이 될 것이라고 알고 있기 때문에 flush()가 없이는 아래 delete는 실행이 안될 것이다.
		postRepository.delete(post);
		postRepository.flush();
	}
}