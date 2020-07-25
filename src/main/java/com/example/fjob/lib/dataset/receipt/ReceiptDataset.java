package com.example.fjob.lib.dataset.receipt;

import java.util.Date;

public class ReceiptDataset {
    private String receiptId;
    private String userName;
    private String fullName;
    private String jobName;
    private Date dueDate;
    private String bidUserName;
    private String bidFullName;
    private String fee;
    private String jobId;
    private String payment;

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getBidUserName() {
        return bidUserName;
    }

    public void setBidUserName(String bidUserName) {
        this.bidUserName = bidUserName;
    }

    public String getBidFullName() {
        return bidFullName;
    }

    public void setBidFullName(String bidFullName) {
        this.bidFullName = bidFullName;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
