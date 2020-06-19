package com.example.fjob.lib.mapper.otp;

import com.example.fjob.lib.dataset.otp.OTPDataset;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OTPMapper {

    @Insert("INSERT INTO OTP " +
            "(USER_NAME, " +
            "EMAIL, " +
            "OTP, " +
            "INS_DATE) " +
            "VALUES" +
            "(#{userName}, " +
            "#{email}, " +
            "#{otp}, " +
            "CURRENT_TIMESTAMP)")
    int insertOTP(OTPDataset otpDataset);

    @Select("SELECT " +
            "INS_DATE AS insDate   " +
            "FROM OTP " +
            "WHERE " +
            "   OTP = #{otp} " +
            "   AND USER_NAME = #{userName}")
    OTPDataset getOTP(OTPDataset otpDataset);

    @Delete("DELETE FROM OTP  " +
            "WHERE OTP = #{otp}  " +
            "AND USER_NAME = #{userName} ")
    int deleteOTP(OTPDataset otpDataset);
}
