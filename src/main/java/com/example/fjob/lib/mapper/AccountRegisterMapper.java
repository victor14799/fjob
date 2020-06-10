package com.example.fjob.lib.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.fjob.lib.dataset.AccountRegisterDataset;

@Mapper
public interface AccountRegisterMapper {

	@Insert("INSERT INTO public.account\r\n" + 
			"(addr, email, first_name, \"password\", phone_no, user_name, last_name, img, ranked, is_student, is_verify, \"role\", balance, del_flg, ins_date)\r\n" + 
			"VALUES('sss', 'sss', 'sss', 'sss', 'sss', 'sss', 'sss', 'sss', 'sss', '0', '0', 'sss', '0', '0',clock_timestamp());") 
	int insertNewAccount(AccountRegisterDataset account);
	
}
