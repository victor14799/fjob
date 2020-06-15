package com.example.fjob.lib.component.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.mapper.account.AccountMapper;

@Component
public class AccountComponentImp implements AccountComponent{
AccountMapper mapper;

@Autowired
public AccountComponentImp(AccountMapper mapper) {
	this.mapper = mapper;
}

// Insert New Account

@Override
public int insertNewAccount(AccountDataset account) {
	
	return mapper.insertNewAccount(account);
}

//Disable Account

@Override
public int disableAccount(String username) {
	return mapper.disableAccount( username);
}

//reset password

@Override
public int resetPassword(AccountDataset account) {
int result = mapper.resetPassword(account);
	return result;
}

//get all user

@Override
public List<AccountDataset> getAllUser() {
	return mapper.getAllUser();
}

// count number of user

@Override
public int countNumberUser() {
	return mapper.countNumberUser();
}



}
