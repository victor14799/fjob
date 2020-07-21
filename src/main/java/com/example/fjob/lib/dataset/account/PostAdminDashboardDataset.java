package com.example.fjob.lib.dataset.account;

public class PostAdminDashboardDataset {
    private String totalPost;
    private String openPost;
    private String pendingPost;
    private String closedPost;

    public String getTotalPost() {
        return totalPost;
    }

    public void setTotalPost(String totalPost) {
        this.totalPost = totalPost;
    }

    public String getOpenPost() {
        return openPost;
    }

    public void setOpenPost(String openPost) {
        this.openPost = openPost;
    }

    public String getPendingPost() {
        return pendingPost;
    }

    public void setPendingPost(String pendingPost) {
        this.pendingPost = pendingPost;
    }

    public String getClosedPost() {
        return closedPost;
    }

    public void setClosedPost(String closedPost) {
        this.closedPost = closedPost;
    }
}
