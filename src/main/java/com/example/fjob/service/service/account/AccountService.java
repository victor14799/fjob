package com.example.fjob.service.service.account;

import java.util.List;

import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.account.AccountLoginDataset;
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

    int updateBalance(String balance, String userName);

//update profile

    int updateProfile(AccountDataset account);

// verify student

    int verifyStudent(String userName, String email);

//get contact

    AccountDataset getContact(String userName);

//get all 

    AccountDataset getAllInfor(String userName);

//get infor for visited 

    AccountDataset getInforForVisiter(String userName);

    //check email is exist or not
    boolean isAccountEmailExist(String email);

    AccountLoginDataset checkLogin(String userName, String password);

//int delete account

int deleteAccount(String userName);

//int setPicture

int setPicture(String userName,String imgUrl);


}
