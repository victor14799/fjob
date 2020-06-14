package com.example.fjob.service.controller.otp;

import com.example.fjob.lib.dataset.otp.OTPDataset;
import com.example.fjob.service.service.otp.OTPService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fjob/v1")
public class OTPController {

    /**
     * OTPService
     */
    private OTPService service;

    /**
     * Constructor for OTPController
     * @param service
     */
    @Autowired
    public OTPController(OTPService service) {
        this.service = service;
    }

    /**
     * getOTP
     * @param param
     * @return
     */
    @GetMapping("/otp")
    OTPDataset getOTP( @RequestBody OTPDataset param){
        return service.getOTP(param);
    }
}
