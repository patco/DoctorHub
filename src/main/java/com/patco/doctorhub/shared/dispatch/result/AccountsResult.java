package com.patco.doctorhub.shared.dispatch.result;

import com.gwtplatform.dispatch.rpc.shared.MultipleResult;
import com.patco.doctorhub.shared.dto.AccountsDto;

public class AccountsResult extends MultipleResult<AccountsDto> {

	private static final long serialVersionUID = 6039293378888682137L;

	private AccountsDto account;

	public AccountsResult() {
	}

	public AccountsResult(AccountsDto account) {
		this.account = account;
	}

	public AccountsDto getSingleAccount() {
		return account;
	}
}
