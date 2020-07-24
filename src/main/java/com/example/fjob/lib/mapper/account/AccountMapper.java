package com.example.fjob.lib.mapper.account;

import java.util.List;

import com.example.fjob.lib.dataset.account.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.fjob.lib.dataset.otp.OTPDataset;

@Mapper
public interface AccountMapper {

    // DISABLE ACCOUNT


    @Update
            ("UPDATE account "
                    + "SET DEL_FLG = '1',"
                    + "UPD_DATE = clock_timestamp() "
                    + "WHERE user_name = #{user_name}")
    int disableAccount(@Param("user_name") String user_name);

    @Update("UPDATE account "
            + "SET DEL_FLG = '0',"
            + "UPD_DATE = clock_timestamp() "
            + "WHERE user_name = #{userName}")
    int enableAccount(@Param("userName") String userName);

    //RESET PASSWORD
    @Update("UPDATE account "
            + "SET password = #{password},"
            + "UPD_DATE = clock_timestamp() "
            + "WHERE user_name = #{userName} "
            + "AND email = #{email} "
            + "AND phone_no = #{phoneNo}")
    int resetPassword(@Param("account") AccountDataset account);

    //GET ALL USER

    @Select("SELECT user_name AS userName,"
            + "addr,"
            + "email,"
            + "first_name AS firstName,"
            + "phone_no AS phoneNo,"
            + "last_name AS lastName,"
            + "img,"
            + "ranked,"
            + "is_student AS isStudent,"
            + "is_verify AS isVerify,"
            + "role AS role,"
            + "balance,"
            + "gender AS gender,"
            + "del_flg AS active "
            + "FROM account "
            + "ORDER BY DEL_FLG")
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
            + "email = #{email}, "
            + "gender = #{gender}, "
            + "birthdate = #{birthdate}, "
            + "UPD_DATE = clock_timestamp() "
            + "WHERE user_name = #{userName}")
    int updateProfile(AccountDataset account);

//	//UPDATE PASSWORD
//	@Update("UPDATE account "
//			+ "SET password = #{password}"
//			+ "UPD_DATE = clock_timestamp() "
//			+ "WHERE user_name = #{userName}")
//	int updatePassword(@Param("password") String password);

   
    //GET CONTACT

    @Select("SELECT COUNT(0) " +
            "FROM ACCOUNT " +
            "WHERE EMAIL = #{email} " +
            "AND IS_VERIFY = '1'")
    int isAccountEmailExisted(@Param("email") String email);

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
            + "balance,"
            + "birthdate as birthdate, "
			+ "gender as gender "
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

    // Delete Account
    @Delete("DELETE FROM account WHERE user_name = #{userName}")
    int deleteAccount(@Param("userName") String userName);


    // Set Picture
    @Update("UPDATE account SET img = #{imgUrl},upd_date = clock_timestamp() WHERE user_name = #{userName}")
    int setPicture(@Param("userName") String userName, @Param("imgUrl") String imgUrl);

    @Select("SELECT USER_NAME AS username,  " +
            "PASSWORD AS password,  " +
            "EMAIL AS email " +
            "FROM ACCOUNT " +
            "WHERE USER_NAME  = #{userName} " +
            "AND DEL_FLG != '1'")
    ApplicationUser login(@Param("userName") String userName);

    @Insert("INSERT INTO ACCOUNT" +
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
            + " '',"
            + " #{email},"
            + " #{firstName},"
            + " #{password},"
            + " #{phoneNo},"
            + " #{username},"
            + " #{lastName},"
            + " '',"
            + " '0',"
            + " #{isStudent},"
            + " #{isVerify},"
            + " '0',"
            + " '0',"
            + " '0',"
            + "clock_timestamp(),"
            + " #{gender})")
    int insertNewAccount(UserSignUpParamDataset user);

    @Select("SELECT COUNT(0) AS totalPost, " +
            "(SELECT COUNT(0) FROM POST WHERE STATUS = '0') AS openPost, " +
            "(SELECT COUNT(0) FROM POST WHERE STATUS = '1') AS pendingPost," +
            "(SELECT COUNT(0) FROM POST WHERE STATUS = '2') AS closedPost " +
            "FROM POST")
    PostAdminDashboardDataset selOverviewPost();

    @Select("SELECT COUNT(0) AS totalUser, " +
            "(SELECT COUNT(0) FROM ACCOUNT WHERE DEL_FLG ='0') AS active, " +
            "(SELECT COUNT(0) FROM ACCOUNT WHERE IS_STUDENT ='1') AS student, " +
            "(SELECT COUNT(0) FROM ACCOUNT WHERE IS_VERIFY ='1') AS verified " +
            "FROM ACCOUNT")
    UserAdminDashboardDataset selOverviewUser();

}
