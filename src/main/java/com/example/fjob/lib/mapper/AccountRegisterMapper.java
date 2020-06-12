package com.example.fjob.lib.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.fjob.lib.dataset.AccountRegisterDataset;

@Mapper
public interface AccountRegisterMapper {

	@Insert("INSERT INTO public.account" + 
			"(addr,"
			+ " email,"
			+ " first_name,"
			+ " password,"
			+ " phone_no,"
			+ " user_name,"
			+ " last_name,"
			+ " img,"
			+ " ranked,"
			+ " is_student,"
			+ " is_verify,"
			+ " role,"
			+ " balance,"
			+ " del_flg,"
			+ " ins_date)" + 
			"VALUES("
			+ " #{accountt.addr},"
			+ " #{accountt.email},"
			+ " #{accountt.firstName},"
			+ " #{accountt.password},"
			+ " #{accountt.phoneNo},"
			+ " #{accountt.userName},"
			+ " #{accountt.lastName},"
			+ " #{accountt.img},"
			+ " #{accountt.ranked},"
			+ " #{accountt.isStudent},"
			+ " #{accountt.isVerify},"
			+ " #{accountt.role},"
			+ " '0',"
			+ " '0',"
			+ "clock_timestamp())") 
	int insertNewAccount(@Param("accountt") AccountRegisterDataset accountt);
	
}
