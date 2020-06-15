package com.example.fjob.service.service.account;

import java.util.List;

import com.example.fjob.lib.dataset.account.AccountDataset;

public interface AccountService {
	 
	//insert new account
	
int insertNewAccount(AccountDataset account);


//disable account

int disableAccount(String username);

//reset password

int resetPassword(AccountDataset account);

//get all user

List<AccountDataset> getAllUser();

//count number of user

int countNumberUser();
}
