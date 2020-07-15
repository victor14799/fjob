package com.example.fjob.service.controller.account;

import java.util.List;

import com.example.fjob.lib.dataset.account.AccountLoginDataset;
import com.example.fjob.lib.dataset.account.LoginAccountRequestDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.otp.OTPDataset;
import com.example.fjob.service.service.account.AccountService;

@RestController
@RequestMapping("fjob/v1/user")
public class AccountController {
    AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

//insert new account

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> insertNewAccount(
            @RequestBody AccountDataset account) {
        if (service.insertNewAccount(account) > 0) {
            return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
    }

    //disable account
    @PutMapping("/disable")
    public ResponseEntity<HttpStatus> disableAccount(@RequestParam("username") String username) {
        service.disableAccount(username);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    //reset password
    @PutMapping("/reset-password")
    public ResponseEntity<Integer> resetPassword(@RequestBody AccountDataset account) {
        Integer result = service.resetPassword(account);
        if (result > 0)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    //get all user
    @GetMapping("/")
    public ResponseEntity<List<AccountDataset>> getAllUser() {
        return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
    }

    //count no user
    @GetMapping("/count")
    public ResponseEntity<Integer> countNumberUser() {
        return new ResponseEntity<>(service.countNumberUser(), HttpStatus.OK);
    }

    //verify account
    @PutMapping("/verify")
    public ResponseEntity<Integer> verifyAccount(@RequestBody OTPDataset otp) {
        Integer result = service.verifyAccount(otp);
        if (result > 0)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<Integer>(result, HttpStatus.NOT_ACCEPTABLE);
    }

    //update balance
    @PutMapping("/update-balance")
    public ResponseEntity<Integer> updateBalance(@RequestParam("balance") String balance, @RequestParam("userName") String userName) {
        Integer result = service.updateBalance(balance, userName);
        if (result > 0)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<Integer>(result, HttpStatus.NOT_ACCEPTABLE);
    }

    //update profile
    @PutMapping("/update-profile")
    public ResponseEntity<Integer> updateProfile(@RequestBody AccountDataset account) {
        Integer result = service.updateProfile(account);
        if (result > 0)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<Integer>(result, HttpStatus.NOT_ACCEPTABLE);
    }

    //verify student
    @PutMapping("/verify-student")
    public ResponseEntity<Integer> verifyStudent(@RequestParam("userName") String userName, @RequestParam("email") String email) {
        Integer result = service.verifyStudent(userName, email);
        if (result > 0)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<Integer>(result, HttpStatus.NOT_ACCEPTABLE);
    }

    //get contact
    @GetMapping("/contact")
    public ResponseEntity<AccountDataset> getContact(@RequestParam("userName") String userName) {
        AccountDataset result = service.getContact(userName);
        if (result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<AccountDataset>(result, HttpStatus.BAD_REQUEST);
    }

    //get all infor
    @GetMapping("/all-infor")
    public ResponseEntity<AccountDataset> getAllInfor(@RequestParam("userName") String userName) {
        AccountDataset result = service.getAllInfor(userName);
        if (result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<AccountDataset>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/isAccountExisted/{email}")
    public boolean checkAccountEmailExisted(@PathVariable("email") String email) {
        return service.isAccountEmailExist(email);
    }

    @PostMapping("/login")
    public AccountLoginDataset checkLogin(@RequestBody LoginAccountRequestDataset requestParam) {
        String userName = requestParam.getUserName();
        String password = requestParam.getPassword();

        return service.checkLogin(userName, password);
    }

//delete account

@DeleteMapping("/delete-account")
public ResponseEntity<Integer> deleteAccount(@RequestParam("userName") String userName){
	Integer result = service.deleteAccount(userName);
	if(result > 0)
	return new ResponseEntity<>(result,HttpStatus.OK);
	return new ResponseEntity<Integer>(result,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
