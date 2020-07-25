package com.example.fjob.lib.mapper.receipt;

import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReceiptMapper {

    @Insert("INSERT INTO RECEIPT " +
            "  (RECEIPT_ID,  " +
            "  USERNAME, " +
            "  FULLNAME,  " +
            "  JOB_NAME,  " +
            "  DUE_DATE,  " +
            "  BID_USERNAME,  " +
            "  BID_FULLNAME,  " +
            "  FEE,  " +
            "  JOB_ID,  " +
            "  PAYMENT,  " +
            "  INS_DATE) " +
            "VALUES " +
            "  ( #{receiptId},  " +
            "    #{userName}, " +
            "    #{fullName},  " +
            "    #{jobName},  " +
            "    #{dueDate},  " +
            "    #{bidUserName},  " +
            "    #{bidFullName},  " +
            "    #{fee}, " +
            "    #{jobId}, " +
            "    #{payment}, " +
            "  CURRENT_TIMESTAMP) ")
    int insReceipt(ReceiptDataset receiptDataset);
}
