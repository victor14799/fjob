package com.example.fjob.service.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fjob.lib.component.account.AccountRegisterComponent;
import com.example.fjob.lib.dataset.account.AccountRegisterDataset;

@Service
public class AccountRegisterServiceImp implements AccountRegisterService{

	AccountRegisterComponent component;
	
	@Autowired
	public AccountRegisterServiceImp(AccountRegisterComponent component) {
		super();
		this.component = component;
	}
	@Override
	public int insertNewAccount(AccountRegisterDataset account) {
		return component.insertNewAccount(account);
	}

	

}
