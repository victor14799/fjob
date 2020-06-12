package com.example.fjob.service.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fjob.lib.dataset.account.AccountRegisterDataset;
import com.example.fjob.service.service.account.AccountRegisterService;

@RestController
@RequestMapping("fjob/v1")
public class AccountRegisterController {
AccountRegisterService service;

@Autowired
public AccountRegisterController(AccountRegisterService service) {
	this.service = service;
}
@PostMapping("/create-account")
public ResponseEntity<HttpStatus> insertNewAccount(
		@RequestBody AccountRegisterDataset account) {
	if(service.insertNewAccount(account) > 0) {
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
}

}
