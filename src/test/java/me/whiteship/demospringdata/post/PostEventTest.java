package me.whiteship.demospringdata.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostEventTest {

	@Autowired
	ApplicationContext ap;

	@Test
	public void event() {
		Post post = new Post();
		post.setTitle("event");
		PostPublishedEvent event = new PostPublishedEvent(post);

		ap.publishEvent(event);
	}
}
