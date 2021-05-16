package me.whiteship.demospringdata.post;

import org.springframework.context.ApplicationListener;

public class PostListener1 implements ApplicationListener<PostPublishedEvent> {
	@Override
	public void onApplicationEvent(PostPublishedEvent postPublishedEvent) {
		System.out.println("-------Listener1----------");
		System.out.println(postPublishedEvent.getPost() + "is published");
		System.out.println("-----------------");
	}
}
