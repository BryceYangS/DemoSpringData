package me.whiteship.demospringdata.post;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
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

		assertThat(postRepository.contains(post)).isFalse();

		postRepository.save(post);

		assertThat(postRepository.contains(post)).isTrue();

		postRepository.delete(post);
		postRepository.flush();
	}
}