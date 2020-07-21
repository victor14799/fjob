package com.example.fjob.lib.component.account;

import com.example.fjob.lib.dataset.account.ApplicationUser;
import com.example.fjob.lib.dataset.account.UserSignUpParamDataset;

public interface ApplicationUserComponent {
    ApplicationUser findByUsername(String username);

    void signUp(UserSignUpParamDataset applicationUser);

}
