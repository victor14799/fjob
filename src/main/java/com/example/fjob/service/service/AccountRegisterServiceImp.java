package com.example.fjob.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fjob.lib.component.AccountRegisterComponent;
import com.example.fjob.lib.dataset.AccountRegisterDataset;

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
