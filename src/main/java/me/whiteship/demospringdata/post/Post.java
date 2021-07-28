package me.whiteship.demospringdata.post;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long Id;

    // 기본으로 vchar 255
    private String title;

    // 기본으로 vchar 255가 넘는 것은 Lob 사용할 것
    @Lob
    private String content;

    // Temporal은 날짜 일때 사용되는 어노테이션
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
