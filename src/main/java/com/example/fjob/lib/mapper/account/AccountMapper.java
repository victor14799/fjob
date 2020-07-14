package com.example.fjob.lib.mapper.account;

import java.util.List;

import com.example.fjob.lib.dataset.account.AccountLoginDataset;
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
            + " ins_date,"
            + " gender)" +
            "VALUES("
            + " #{addr},"
            + " #{email},"
            + " #{firstName},"
            + " #{password},"
            + " #{phoneNo},"
            + " #{userName},"
            + " #{lastName},"
            + " #{img},"
            + " #{ranked},"
            + " #{isStudent},"
            + " #{isVerify},"
            + " #{role},"
            + " '0',"
            + " '0',"
            + "clock_timestamp(),"
            + " #{gender})")
    int insertNewAccount(AccountDataset account);


    // DISABLE ACCOUNT


    @Update
            ("UPDATE account "
                    + "SET DEL_FLG = '1',"
                    + "UPD_DATE = clock_timestamp() "
                    + "WHERE user_name = #{user_name}")
    int disableAccount(@Param("user_name") String user_name);

    //RESET PASSWORD
    @Update("UPDATE account "
            + "SET password = #{password},"
            + "UPD_DATE = clock_timestamp() "
            + "WHERE user_name = #{userName} "
            + "AND email = #{email} "
            + "AND phone_no = #{phoneNo}")
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

    //GET CONTACT

    @Select("Select phone_no as phoneNo,"
            + "addr,"
            + "email "
            + "FROM account "
            + "WHERE user_name = #{userName}")
    AccountDataset getContact(@Param("userName") String userName);

    //GET ALL INFOR
    //skill?
    @Select("SELECT user_name as userName,"
            + "first_name as firstName,"
            + "last_name as lastName,"
            + "addr,"
            + "phone_no as phoneNo,"
            + "email,"
            + "img,"
            + "ranked,"
            + "is_student as isStudent,"
            + "role,"
            + "balance "
            + "FROM account "
            + "WHERE user_name = #{userName}")
    AccountDataset getAllInfor(@Param("userName") String userName);

    //GET INFOR FOR VISITER
    //skill?
    @Select("SELECT user_name as userName,"
            + "first_name as firstName,"
            + "last_name as lastName,"
            + "img,"
            + "ranked,"
            + "is_student as isStudent,"
            + "role,"
            + "balance "
            + "FROM account "
            + "WHERE user_name = #{userName}")
    AccountDataset getInforForVisiter(@Param("userName") String userName);

    @Select("SELECT COUNT(0) " +
            "FROM ACCOUNT " +
            "WHERE EMAIL = #{email} " +
            "AND IS_VERIFY = '1'")
    int isAccountEmailExisted(@Param("email") String email);

    @Select("SELECT USER_NAME AS userName,  " +
            "FIRST_NAME AS firstName,  " +
            "LAST_NAME AS lastName," +
            "EMAIL AS email,  " +
            "IMG AS img," +
            "BALANCE AS balance " +
            "FROM ACCOUNT  " +
            "WHERE USER_NAME  = #{userName} " +
            "AND PASSWORD =#{password}")
    AccountLoginDataset login(@Param("userName") String userName, @Param("password") String password);
}
