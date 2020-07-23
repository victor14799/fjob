package com.example.fjob.lib.component.account;

import java.util.List;

import com.example.fjob.lib.component.otp.OTPComponent;
import com.example.fjob.lib.dataset.account.*;
import com.example.fjob.lib.dataset.otp.OTPDataset;

public interface AccountComponent {

    //insert new account

    int insertNewAccount(UserSignUpParamDataset account);

    //disable account

    int disableAccount(String username);

    int enableAccount(String userName);

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

// //update password
// 
// int updatePassword(String password);

    //verify student

    int verifyStudent(String userName, String email);

    //get contact

    AccountDataset getContact(String userName);

    //get all

    AccountDataset getAllInfor(String userName);

    //get infor for visited

    AccountDataset getInforForVisiter(String userName);

    boolean isExistedEmail(String email);

    AccountLoginDataset checkLogin(String userName, String password);


    //delete account

    int deleteAccount(String userName);

    //set picture
    int setPicture(String userName, String imgUrl);

    PostAdminDashboardDataset selOverviewPost();

    UserAdminDashboardDataset selOverviewUser();

}
