package me.whiteship.demospringdata.post;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.types.Predicate;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;

	@Test
	public void crud() {
		Post post = new Post();
		post.setTitle("hibernate");

		assertThat(postRepository.contains(post)).isFalse();

		// save 할 때 event 발생함
		postRepository.save(post.publish());

		assertThat(postRepository.contains(post)).isTrue();

		postRepository.delete(post);
		postRepository.flush();
	}

	@Test
	public void queryDsl() {
		Post post = new Post();
		post.setTitle("hibernate");
		postRepository.save(post.publish());

		Predicate predicate = QPost.post
			.title.containsIgnoreCase("Hi");

		Optional<Post> one = postRepository.findOne(predicate);
		assertThat(one).isNotEmpty();

	}

}