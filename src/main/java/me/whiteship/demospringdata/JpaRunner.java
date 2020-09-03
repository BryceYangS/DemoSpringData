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

        Study SpringDataJPAStudy = new Study();
        SpringDataJPAStudy.setName("Spring Data JPA");

        Study AlgorithmsStudy = new Study();
        AlgorithmsStudy.setName("Algorithms");

        /* [Start] 보통 관계 관련된 소스는 한 묶음으로 보고 관리 --> Method 단위로 한 번에 처리하는게 좋음
        *    - 관계와 관련된 method : "Convenient Method"라고 부름
        *  */
//        account.getStudies().add(study);
//        // 주인한테 관계 설정을 반드시 해줘야 DB에 반영이 된다!!!
//        study.setOwner(account);
        account.addStudy(SpringDataJPAStudy);
        account.addStudy(AlgorithmsStudy);
        /* [End] */


        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(SpringDataJPAStudy);
        session.save(AlgorithmsStudy);
    }
}
