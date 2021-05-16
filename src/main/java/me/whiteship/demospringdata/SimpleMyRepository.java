package me.whiteship.demospringdata;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class SimpleMyRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

	private EntityManager entityManager;

	public SimpleMyRepository(JpaEntityInformation<T, ?> entityInformation,
		EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public boolean contains(T entity) {
		return entityManager.contains(entity);
	}
}
