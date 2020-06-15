package com.example.fjob.service.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fjob.lib.component.account.AccountComponent;
import com.example.fjob.lib.dataset.account.AccountDataset;

@Service
public class AccountServiceImp implements AccountService{

	AccountComponent component;
	
	@Autowired
	public AccountServiceImp(AccountComponent component) {
		super();
		this.component = component;
	}
	
	//insert new account
	
	@Override
	public int insertNewAccount(AccountDataset account) {
		return component.insertNewAccount(account);
	}
	
	//disable account
	
	@Override
	public int disableAccount(String username) {
		return component.disableAccount(username);
	}

	//reset password
	
	@Override
	public int resetPassword(AccountDataset account) {
		return component.resetPassword(account);
	}

	//get all user
	
	@Override
	public List<AccountDataset> getAllUser() {
		return component.getAllUser();
	}

	
	//count no user
	
	@Override
	public int countNumberUser() {
		return component.countNumberUser();
	}

	

}
