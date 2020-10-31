package me.whiteship.demospringdata;

import javax.persistence.*;

@Entity
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    private Integer likeCount = 0;

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
