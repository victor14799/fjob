package com.example.fjob.lib.component.account;

import com.example.fjob.lib.dataset.account.ApplicationUser;
import com.example.fjob.lib.dataset.account.UserSignUpParamDataset;
import com.example.fjob.lib.mapper.account.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserComponentImpl implements ApplicationUserComponent {

    private AccountMapper mapper;

    @Autowired
    public ApplicationUserComponentImpl(AccountMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ApplicationUser findByUsername(String username) {
        return mapper.login(username);
    }

    @Override
    public void signUp(UserSignUpParamDataset applicationUser) {
        int result = mapper.insertNewAccount(applicationUser);
        if(result > 0){
            System.out.println("Insert OK");
        } else {
            System.out.println("Insert FAIL");
        }

    }
}
