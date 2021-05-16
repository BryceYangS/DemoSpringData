package me.whiteship.demospringdata.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {
	@Bean
	public PostListener1 postListener1() {
		return new PostListener1();
	}

	@Bean
	public PostListener2 postListener2() {
		return new PostListener2();
	}

	@Bean
	public ApplicationListener<PostPublishedEvent> postListener3() {
		return postPublishedEvent -> {
			System.out.println("-------Listener3----------");
			System.out.println(postPublishedEvent.getPost() + "is published");
			System.out.println("-----------------");
		};
	}

}
