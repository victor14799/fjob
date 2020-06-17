package com.example.fjob.service.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fjob.lib.component.account.AccountComponent;
import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.otp.OTPDataset;

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

	//verify account
	
	@Override
	public int verifyAccount(OTPDataset otp) {
		return component.verifyAccount(otp);
	}

	//update balance
	
	@Override
	public int updateBalance(String balance, String userName) {
		return component.updateBalance(balance, userName);
	}

	//update profile 
	
	@Override
	public int updateProfile(AccountDataset account) {
		return component.updateProfile(account);
	}

//	@Override
//	public int updatePassword(String password) {
//		return component.updatePassword(password);
//	}

	
	//verify student
	@Override
	public int verifyStudent(String userName, String email) {
		return component.verifyStudent(userName, email);
	}

	

}
