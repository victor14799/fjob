package com.example.fjob.lib.dataset.bid;

import com.example.fjob.common.CommonUtils;

import java.util.Date;

public class CommentDataset {
    private String bidUser;
    private String fullName;
    private String price;
    private Date dueDate;
    private String imgUrl;
    private Date insDate;

    public String getBidUser() {
        return bidUser;
    }

    public void setBidUser(String bidUser) {
        this.bidUser = bidUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPrice() {
        return CommonUtils.formatMoney(this.price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getImgUrl() {
        return imgUrl != null? imgUrl : "";
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }
}
