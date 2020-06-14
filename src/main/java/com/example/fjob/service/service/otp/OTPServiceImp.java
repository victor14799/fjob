package com.example.fjob.service.service.otp;

import com.example.fjob.lib.component.otp.OTPComponent;
import com.example.fjob.lib.dataset.otp.OTPDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPServiceImp implements  OTPService {
    OTPComponent component;

    /**
     * Constructor for OTPServiceImp
     * @param component
     */
    @Autowired
    public OTPServiceImp(OTPComponent component) {
        this.component = component;
    }
    /**
     * getOTP
     * @param paramDataset
     * @return
     */
    @Override
    public OTPDataset getOTP(OTPDataset paramDataset) {
        return component.getOTP(paramDataset);
    }


}
