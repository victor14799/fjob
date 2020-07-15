package com.example.fjob.lib.component.account;

import java.util.List;

import com.example.fjob.lib.dataset.account.AccountLoginDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fjob.lib.component.otp.OTPComponent;
import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.otp.OTPDataset;
import com.example.fjob.lib.mapper.account.AccountMapper;

@Component
public class AccountComponentImp implements AccountComponent {

    AccountMapper mapper;
    OTPComponent otpComponent;

    @Autowired
    public AccountComponentImp(AccountMapper mapper, OTPComponent otpComponent) {
        this.mapper = mapper;
        this.otpComponent = otpComponent;
    }

// Insert New Account

    @Override
    public int insertNewAccount(AccountDataset account) {

        return mapper.insertNewAccount(account);
    }

//Disable Account

    @Override
    public int disableAccount(String username) {
        return mapper.disableAccount(username);
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

//verify account

    @Override
    public int verifyAccount(OTPDataset otp) {
        boolean result = otpComponent.validateOTP(otp);
        if (result) {
            return mapper.verifyAccount(otp);
        }
        return 0;
    }

//update balance

    @Override
    public int updateBalance(String balance, String userName) {
        return mapper.updateBalance(balance, userName);
    }

//update profile

    @Override
    public int updateProfile(AccountDataset account) {
        return mapper.updateProfile(account);
    }

////update password
//
//@Override
//public int updatePassword(String password) {
//	return mapper.updatePassword(password);
//}


//verify student

    @Override
    public int verifyStudent(String userName, String email) {
        boolean result = email.endsWith("fpt.edu.vn");
        if (result) {
            return mapper.verifyStudent(userName);
        }
        return 0;
    }

//get contact

    @Override
    public AccountDataset getContact(String userName) {
        AccountDataset account = mapper.getContact(userName);
        System.out.println(account.getPhoneNo() + "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSs");
        return mapper.getContact(userName);
    }

    //get all infor
    @Override
    public AccountDataset getAllInfor(String userName) {
        return mapper.getAllInfor(userName);
    }

    @Override
    public AccountDataset getInforForVisiter(String userName) {
        return mapper.getInforForVisiter(userName);
    }

    @Override
    public boolean isExistedEmail(String email) {
        return mapper.isAccountEmailExisted(email) > 0;
    }

    @Override
    public AccountLoginDataset checkLogin(String userName, String password) {
        return mapper.login(userName, password);
    }


//get all infor



//delete account
@Override
public int deleteAccount(String userName) {
	
	return mapper.deleteAccount(userName);
}


}