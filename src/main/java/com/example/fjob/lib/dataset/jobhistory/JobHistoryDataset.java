package com.example.fjob.lib.dataset.jobhistory;

import java.util.Date;

public class JobHistoryDataset {

    private String title;

    private String userName;

    private String price;

    private String feedback;

    private String comment;

    private String status;

    private Date startDate;

    private Date endDate;

    public String getTitle() {
        return title;
    }

    /**
     * setTitle
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getUserName
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * setUserName
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * getPrice
     * @return
     */
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
