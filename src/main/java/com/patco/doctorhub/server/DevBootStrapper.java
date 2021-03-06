package com.patco.doctorhub.server;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.patco.doctorhub.server.domain.dao.sales.AccountDao;
import com.patco.doctorhub.server.domain.sales.Account;
import com.patco.doctorhub.server.domain.sales.Address;
/**
 * Creates mock data
 * @author KonstantinosP
 *
 */
public class DevBootStrapper {

	private final AccountDao accountDao;
	
	@Inject
	public DevBootStrapper(AccountDao accountDao) {
		this.accountDao=accountDao;
		init();
	}
	
	private void init(){
		deleteAll();
		createMockData();
	}
	
	private void deleteAll(){
		deleteAllAccounts();
	}
	
	private void deleteAllAccounts(){
		List<Account> accounts =accountDao.retrieveAccounts();
		for(Account account:accounts){
			accountDao.deleteAccount(account);
		}
	}
	
	private void createMockData(){
		createMockAccountData();
	}
	
	private void createMockAccountData() {
		 if (accountDao.retrieveAccounts().isEmpty()){

				Account company1 = new Account();
				company1.setAccountName("ABC Corporation Pty Ltd");
				company1.setAccountNumber("ABN: 111 111 111");
				company1.setMainPhone("(01) 1111 1111");

				List<Address> company1Addresses = new ArrayList<Address>();
				Address address1 = new Address();
				address1.setAddressName("ABC House");
				address1.setAddressLine1("Level 1");
				address1.setAddressLine2("111 Kent Street");
				address1.setCity("Sydney");
				address1.setState("NSW");
				address1.setPostalCode("2000");
				address1.setCountry("Australia");
				address1.setAddressType("Business");

				company1Addresses.add(address1);
				company1.setAddresses(company1Addresses);

				company1.setPrimaryContact("Darren Poyner");
				company1.setEmailPrimaryContact("sales@uptick.com.au");

				//
				// Account: Company 2
				//

				Account company2 = new Account();
				company2.setAccountName("DEF Corporation Pty Ltd");
				company2.setAccountNumber("ABN: 222 222 222");
				company2.setMainPhone("(02) 2222 2222");

				List<Address> company2Addresses = new ArrayList<Address>();
				Address address2 = new Address();
				address2.setAddressName("DEF House");
				address2.setAddressLine1("Level 2");
				address2.setAddressLine2("222 Kent Street");
				address2.setCity("Sydney");
				address2.setState("NSW");
				address2.setPostalCode("2000");
				address2.setCountry("Australia");
				address2.setAddressType("Business");

				company2Addresses.add(address2);
				company2.setAddresses(company2Addresses);

				company2.setPrimaryContact("Scott Davies");
				company2.setEmailPrimaryContact("sales@uptick.com.au");

				//
				// Account: Company 3
				//

				Account company3 = new Account();
				company3.setAccountName("GHI Corporation Pty Ltd");
				company3.setAccountNumber("ABN: 333 333 333");
				company3.setMainPhone("(03) 3333 3333 ");

				List<Address> company3Addresses = new ArrayList<Address>();
				Address address3 = new Address();
				address3.setAddressName("GHI House");
				address3.setAddressLine1("Level 3");
				address3.setAddressLine2("333 Kent Street");
				address3.setCity("Sydney");
				address3.setState("NSW");
				address3.setPostalCode("2000");
				address3.setCountry("Australia");
				address3.setAddressType("Business");

				company3Addresses.add(address3);
				company3.setAddresses(company3Addresses);

				company3.setPrimaryContact("Ross Hodge");
				company3.setEmailPrimaryContact("sales@uptick.com.au");

				//
				// Account: Company 4
				//

				Account company4 = new Account();
				company4.setAccountName("JKL Corporation Pty Ltd");
				company4.setAccountNumber("ABN: 444 444 444");
				company4.setMainPhone("(04) 4444 4444");

				List<Address> company4Addresses = new ArrayList<Address>();
				Address address4 = new Address();
				address4.setAddressName("GHI House");
				address4.setAddressLine1("Level 4");
				address4.setAddressLine2("444 Kent Street");
				address4.setCity("Sydney");
				address4.setState("NSW");
				address4.setPostalCode("2000");
				address4.setCountry("Australia");
				address4.setAddressType("Business");

				company4Addresses.add(address4);
				company4.setAddresses(company4Addresses);

				company4.setPrimaryContact("Graham King");
				company4.setEmailPrimaryContact("sales@uptick.com.au");

				//
				// Account: Company 5
				//

				Account company5 = new Account();
				company5.setAccountName("MNO Corporation Pty Ltd");
				company5.setAccountNumber("ABN: 555 555 555");
				company5.setMainPhone("(05) 5555 5555");

				List<Address> company5Addresses = new ArrayList<Address>();

				Address address5 = new Address();
				address5.setAddressName("GHI House");
				address5.setAddressLine1("Level 5");
				address5.setAddressLine2("555 Kent Street");
				address5.setCity("Sydney");
				address5.setState("NSW");
				address5.setPostalCode("2000");
				address5.setCountry("Australia");
				address5.setAddressType("Business");

				company5Addresses.add(address5);
				company5.setAddresses(company5Addresses);

				company5.setPrimaryContact("Sean Doyle");
				company5.setEmailPrimaryContact("sales@uptick.com.au");


				accountDao.createAccount(company1);
				accountDao.createAccount(company2);
				accountDao.createAccount(company3);
				accountDao.createAccount(company4);
				accountDao.createAccount(company5);
			 
		 }
	 }
	
	
}
