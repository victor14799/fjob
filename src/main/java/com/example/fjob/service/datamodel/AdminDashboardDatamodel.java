package com.example.fjob.service.datamodel;

import com.example.fjob.lib.dataset.account.PostAdminDashboardDataset;
import com.example.fjob.lib.dataset.account.UserAdminDashboardDataset;

public class AdminDashboardDatamodel {
    private PostAdminDashboardDataset postAdminDashboardDataset;
    private UserAdminDashboardDataset userAdminDashboardDataset;

    public PostAdminDashboardDataset getPostAdminDashboardDataset() {
        return postAdminDashboardDataset;
    }

    public void setPostAdminDashboardDataset(PostAdminDashboardDataset postAdminDashboardDataset) {
        this.postAdminDashboardDataset = postAdminDashboardDataset;
    }

    public UserAdminDashboardDataset getUserAdminDashboardDataset() {
        return userAdminDashboardDataset;
    }

    public void setUserAdminDashboardDataset(UserAdminDashboardDataset userAdminDashboardDataset) {
        this.userAdminDashboardDataset = userAdminDashboardDataset;
    }
}
