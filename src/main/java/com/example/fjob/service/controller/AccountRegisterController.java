package com.example.fjob.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fjob.lib.dataset.AccountRegisterDataset;
import com.example.fjob.service.service.AccountRegisterService;

@RestController
@RequestMapping("fjob/v1")
public class AccountRegisterController {
AccountRegisterService service;

@Autowired
public AccountRegisterController(AccountRegisterService service) {
	this.service = service;
}
@PostMapping("/create-account")
public int insertNewAccount(
		@RequestBody AccountRegisterDataset account) {
	return service.insertNewAccount(account);
}

}
