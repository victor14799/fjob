package com.example.fjob.lib.component.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fjob.lib.dataset.account.AccountRegisterDataset;
import com.example.fjob.lib.mapper.account.AccountRegisterMapper;

@Component
public class AccountRegisterComponentImp implements AccountRegisterComponent{
AccountRegisterMapper mapper;

@Autowired
public AccountRegisterComponentImp(AccountRegisterMapper mapper) {
	this.mapper = mapper;
}

@Override
public int insertNewAccount(AccountRegisterDataset account) {
	
	return mapper.insertNewAccount(account);
}


}
