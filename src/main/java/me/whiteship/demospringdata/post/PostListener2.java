package me.whiteship.demospringdata.post;

import org.springframework.context.event.EventListener;

public class PostListener2 {

	@EventListener
	public void listen(PostPublishedEvent postPublishedEvent) {
		System.out.println("-------Listener2----------");
		System.out.println(postPublishedEvent.getPost() + "is published");
		System.out.println("-----------------");
	}
}
