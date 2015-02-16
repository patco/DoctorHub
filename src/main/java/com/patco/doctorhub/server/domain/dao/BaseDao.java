package com.patco.doctorhub.server.domain.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDao {
	
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("com.patco.doctorhub");

	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
