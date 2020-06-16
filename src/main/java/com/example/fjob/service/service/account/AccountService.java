package com.example.fjob.service.service.account;

import java.util.List;

import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.otp.OTPDataset;

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

//verify account

int verifyAccount(OTPDataset otp);

//update balance

int updateBalance(String balance,String userName);
}
