package com.example.fjob.lib.mapper.account;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.otp.OTPDataset;

@Mapper
public interface AccountMapper {
	
// INSERT NEW ACCOUNT
	
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
			+ " #{account.addr},"
			+ " #{account.email},"
			+ " #{account.firstName},"
			+ " #{account.password},"
			+ " #{account.phoneNo},"
			+ " #{account.userName},"
			+ " #{account.lastName},"
			+ " #{account.img},"
			+ " #{account.ranked},"
			+ " #{account.isStudent},"
			+ " #{account.isVerify},"
			+ " #{account.role},"
			+ " '0',"
			+ " '0',"
			+ "clock_timestamp())") 
	int insertNewAccount(@Param("accountt") AccountDataset account);
	
	
	// DISABLE ACCOUNT 
	
	
	@Update
	("UPDATE account "
			+ "SET DEL_FLG = '1',"
			+ "UPD_DATE = clock_timestamp() "
			+ "WHERE user_name = #{username}")
	int disableAccount(@Param("username") String username);
	
	//RESET PASSWORD 
	@Update ("UPDATE account "
			+ "SET password = #{account.password},"
			+ "UPD_DATE = clock_timestamp() "
			+ "WHERE user_name = #{account.userName} "
			+ "AND email = #{account.email} "
			+ "AND phone_no = #{account.phoneNo}")
	int resetPassword(@Param("account") AccountDataset account);
	 
	//GET ALL USER
	
	@Select("SELECT user_name,"
			+ "addr,"
			+ "email,"
			+ "first_name,"
			+ "password,"
			+ "phone_no,"
			+ "last_name,"
			+ "img,"
			+ "ranked,"
			+ "is_student,"
			+ "is_verify,"
			+ "role,"
			+ "balance FROM account")
	List<AccountDataset> getAllUser();
	
	//COUNT NUMBER OF USER
	
	@Select("SELECT "
			+ "COUNT(user_name) "
			+ "FROM account")
	int countNumberUser();
	
	//VERIFY ACCOUNT 
	
	@Update("UPDATE account "
			+ "SET is_verify = '1', "
			+ "UPD_DATE = clock_timestamp() "
			+ "WHERE user_name = #{otp.userName}")
	int verifyAccount(@Param("otp") OTPDataset otp);
	
	
	//UPDATE BALANCE
	@Update("UPDATE account "
			+ "SET BALANCE = #{balance},"
			+ "UPD_DATE = clock_timestamp()  "
			+ "WHERE user_name = #{userName}")
	int updateBalance(@Param("balance") String balance, @Param("userName") String userName);
	
	//UPDATE PROFILE
	@Update("UPDATE account "
			+ "SET first_name = #{firstName},"
			+ "last_name = #{lastName},"
			+ "addr = #{addr},"
			+ "phone_no = #{phoneNo},"
			+ "img = #{img},"
			+ "role = #{role},"
			+ "email = #{email},"
			+ "UPD_DATE = clock_timestamp() "
			+ "WHERE user_name = #{userName}")
	int updateProfile(AccountDataset account);
	
//	//UPDATE PASSWORD
//	@Update("UPDATE account "
//			+ "SET password = #{password}"
//			+ "UPD_DATE = clock_timestamp() "
//			+ "WHERE user_name = #{userName}")
//	int updatePassword(@Param("password") String password);
	
	//VERIFY STUDENT
	@Update("UPDATE account "
			+ "SET is_student = '1',"
			+ "UPD_DATE = clock_timestamp() "
			+ "WHERE user_name = #{userName}")
	int verifyStudent(@Param("userName") String userName);
}
