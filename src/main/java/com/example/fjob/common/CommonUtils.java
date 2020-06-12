package com.example.fjob.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtils {

    private static final int NUMERAL_BINARY = 48; // numeral '0'

    private static final int LETTER_BINARY = 122; // letter 'z'

    private static final int STRING_LENGTH = 10; // random String with 10 chars

    private static final int OTP_LENGTH = 6; // random OTP with 6 numbers

    public static String randomID(){
        Random random = new Random();

        String generatedString = random.ints(NUMERAL_BINARY, LETTER_BINARY + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(STRING_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static String convertDateToString(String pattern, Date date){
        DateFormat df = new SimpleDateFormat(pattern);
        String convertedDate  = df.format(date);
        return convertedDate;
    }

    public static String generateOTP(){
        Random obj = new Random();
        char[] otp = new char[OTP_LENGTH];
        String results ="";
        for (int i=0; i<OTP_LENGTH; i++)
        {
            otp[i]= (char)(obj.nextInt(10)+48);
            results += otp[i];
        }
        return results;
    }
}
