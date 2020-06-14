package com.example.fjob.lib.component.otp;

import com.example.fjob.common.CommonUtils;
import com.example.fjob.lib.dataset.otp.OTPDataset;
import com.example.fjob.lib.mapper.otp.OTPMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OTPComponentImp implements OTPComponent {

    /**
     * OTPMapper
     */
    private OTPMapper mapper;

    /**
     * VALID_TIME
     */
    private final int VALID_TIME = 5; // 5 MINUTES to validate OTP

    /**
     * Construstor for OTPComponentImp
     * @param mapper
     */
    @Autowired
    public OTPComponentImp(OTPMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * getOTP
     * @param paramDataset
     * @return
     */
    @Override
    public OTPDataset getOTP(OTPDataset paramDataset) {
        // Generate OTP
        String otp = CommonUtils.generateOTP();
        paramDataset.setOtp(otp);

        System.out.println("=====> OTP is: "+otp);
        //Insert OTP to DB
        int insertResult = mapper.insertOTP(paramDataset);
        //Response
        OTPDataset result = new OTPDataset();
        if (insertResult > 0) {
            result = paramDataset;
        }
        return result;
    }

    /**
     * validateOTP
     * @param otpDataset
     * @return
     */
    @Override
    public boolean validateOTP(OTPDataset otpDataset) {
        // Check is have OTP in DB yet
        OTPDataset otp = mapper.getOTP(otpDataset);

        if(otp != null){
            Date realTime = new Date();
            // If OTP is inserted 5 minutes less than real-time
            if ((realTime.getTime() - otp.getInsDate().getTime())/1000/60 < VALID_TIME){
                mapper.deleteOTP(otpDataset);
                return true;
            }
            mapper.deleteOTP(otpDataset);
        }

        return false;
    }
}
