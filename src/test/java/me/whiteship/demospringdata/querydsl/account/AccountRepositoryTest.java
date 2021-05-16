package me.whiteship.demospringdata.querydsl.account;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.types.Predicate;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void crud() {
		QAccount account = QAccount.account;
		Predicate predicate = QAccount.account
				.firstName.containsIgnoreCase("keesun")
				.and(account.lastName.startsWith("baik"));

		Optional<Account> one = accountRepository.findOne(predicate);
		assertThat(one).isEmpty();
	}
}