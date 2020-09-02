package me.whiteship.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.rmi.StubNotFoundException;
import java.util.HashSet;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("------JpaRunner");
        Account account = new Account();
        account.setUsername("Yang2");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.getStudies().add(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
//        entityManager.persist(account);
    }
}
