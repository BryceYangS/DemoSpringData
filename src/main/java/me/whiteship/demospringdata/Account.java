package me.whiteship.demospringdata;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false,  unique = true)
    private String username;
    private String password;
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime = new Date();

    @Transient //컬럼 매핑 하지 않음
    private String no;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address address;

    @OneToMany
    private Set<Study> studies = new HashSet<>();

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
