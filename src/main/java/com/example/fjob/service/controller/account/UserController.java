package com.example.fjob.service.controller.account;

import com.example.fjob.lib.component.account.ApplicationUserComponent;
import com.example.fjob.lib.dataset.account.UserSignUpParamDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private ApplicationUserComponent applicationUserComponent;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(ApplicationUserComponent applicationUserComponent,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserComponent = applicationUserComponent;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserSignUpParamDataset user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserComponent.signUp(user);
    }

    @GetMapping("/namne")
    public String hello(){
        return "hello";
    }
}
