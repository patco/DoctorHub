package com.patco.doctorhub.server.domain.dao.sales;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.patco.doctorhub.server.domain.dao.BaseDao;
import com.patco.doctorhub.server.domain.sales.Account;

public class AccountDao extends BaseDao {

	public Long createAccount(Account account) {

		// For an application-managed entity manager its best practice to create
		// a
		// new entity manager inside a method and close it before the method is
		// finished.

		EntityManager em = createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Long accountId = -1L;

		try {
			tx.begin();
			em.persist(account);
			accountId = account.getAccountId();
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		return accountId;
	}

	public Account retrieveAccount(Long accountId) {

		EntityManager em = createEntityManager();
		Account account = null;

		try {
			TypedQuery<Account> query = em.createQuery(
					"select a from Account a where a.accountId = ?1",
					Account.class);
			query.setParameter(1, accountId);
			account = query.getSingleResult();
		} finally {
			em.close();
		}

		return account;
	}

	public List<Account> retrieveAccounts() {

		EntityManager em = createEntityManager();
		List<Account> list = null;

		try {
			TypedQuery<Account> query = em.createQuery(
					"select a from Account a", Account.class);
			list = query.getResultList();
		} finally {
			em.close();
		}

		return list;
	}

	public Account updateAccount(Account account) {

		EntityManager em = createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Account account2 = null;

		try {
			tx.begin();
			account2 = em.merge(account);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		return account2;
	}

	public void deleteAccount(Account account) {

		EntityManager em = createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.remove(em.merge(account));
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

}
