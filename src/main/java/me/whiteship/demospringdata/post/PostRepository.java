package me.whiteship.demospringdata.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import me.whiteship.demospringdata.MyRepository;
import me.whiteship.demospringdata.SimpleMyRepository;

public interface PostRepository extends MyRepository<Post, Long> {

}
