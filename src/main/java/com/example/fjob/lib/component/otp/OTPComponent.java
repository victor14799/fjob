package com.example.fjob.lib.component.otp;

import com.example.fjob.lib.dataset.otp.OTPDataset;

public interface OTPComponent {
    /**
     * getOTP
     * @param otpDataset
     * @return
     */
    OTPDataset getOTP(OTPDataset otpDataset);
    /**
     * validateOTP
     * @param otpDataset
     * @return
     */
    boolean validateOTP(OTPDataset otpDataset);
}
