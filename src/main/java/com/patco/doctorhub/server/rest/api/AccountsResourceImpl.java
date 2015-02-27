package com.patco.doctorhub.server.rest.api;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.patco.doctorhub.server.domain.dao.sales.AccountDao;
import com.patco.doctorhub.server.domain.sales.Account;
import com.patco.doctorhub.shared.dto.AccountsDto;
import com.patco.doctorhub.shared.rest.api.AccountsResource;

public class AccountsResourceImpl implements AccountsResource {

	private final AccountDao accountDao;

	@Inject
	public AccountsResourceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<AccountsDto> getAccounts() {
		List<AccountsDto> accountsDtos = new ArrayList<AccountsDto>();
		List<Account> accounts = accountDao.retrieveAccounts();
		if (accounts != null) {
			for (Account account : accounts) {
				accountsDtos.add(createAccountsDto(account));
			}
		}
		return accountsDtos;
	}

	private AccountsDto createAccountsDto(Account account) {
		return new AccountsDto(account.getAccountId(),
				account.getAccountName(), account.getMainPhone(),
				account.getLocation(), account.getPrimaryContact(),
				account.getEmailPrimaryContact());
	}

}
