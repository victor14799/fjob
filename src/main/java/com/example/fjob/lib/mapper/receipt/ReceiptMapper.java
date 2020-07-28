package com.example.fjob.lib.mapper.receipt;

import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import com.example.fjob.lib.dataset.receipt.ReceiptHistoryDataset;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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


    @Select("SELECT  RECEIPT_ID AS receiptId , " +
            "FULLNAME AS sender, " +
            "BID_FULLNAME AS receiver, " +
            "JOB_NAME AS description, " +
            "FEE AS amount, " +
            "INS_DATE AS insDate, " +
            "PAYMENT AS paymentMethod " +
            "FROM RECEIPT")
    List<ReceiptHistoryDataset> selTransactionsAdmin();

    @Select("SELECT  RECEIPT_ID AS receiptId , " +
            "FULLNAME AS sender, " +
            "BID_FULLNAME AS receiver, " +
            "JOB_NAME AS description, " +
            "FEE AS amount, " +
            "INS_DATE AS insDate, " +
            "PAYMENT AS paymentMethod " +
            "FROM RECEIPT " +
            "WHERE USERNAME = #{userName}")
    List<ReceiptHistoryDataset> selUserTransactions(@Param("userName") String userName);
}
