package com.patco.doctorhub.server.domain.dao.sales;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.patco.doctorhub.server.domain.sales.Account;

public class AccountDao {

	@Inject
	EntityManager em;

	@Transactional
	public Long createAccount(Account account) {
		Long accountId = -1L;
		em.persist(account);
		accountId = account.getAccountId();
		return accountId;
	}

	@Transactional
	public Account retrieveAccount(Long accountId) {
		Account account = null;
		TypedQuery<Account> query = em
				.createQuery("select a from Account a where a.accountId = ?1",
						Account.class);
		query.setParameter(1, accountId);
		account = query.getSingleResult();

		return account;
	}

	@Transactional
	public List<Account> retrieveAccounts() {
		List<Account> list = null;
		TypedQuery<Account> query = em.createQuery("select a from Account a",
				Account.class);
		list = query.getResultList();
		return list;
	}

	@Transactional
	public Account updateAccount(Account account) {
		return em.merge(account);
	}

	@Transactional
	public void deleteAccount(Account account) {
		em.remove(em.merge(account));
	}

}
