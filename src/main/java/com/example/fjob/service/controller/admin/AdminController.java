package com.example.fjob.service.controller.admin;

import com.example.fjob.lib.dataset.post.PostAdminOverviewDataset;
import com.example.fjob.service.datamodel.AdminDashboardDatamodel;
import com.example.fjob.service.service.account.AccountService;
import com.example.fjob.service.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fjob/v1/admin")
public class AdminController {
    private AccountService accountService;

    private PostService postService;

    @Autowired
    public AdminController(AccountService accountService, PostService postService) {
        this.accountService = accountService;
        this.postService = postService;
    }

    @GetMapping("/dashboard")
    public AdminDashboardDatamodel getAdminDashboard() {
        return accountService.getAdminDashboard();
    }

    @GetMapping("/posts")
    public List<PostAdminOverviewDataset> getAdminPostOverview(){
        return postService.selAdminPostOverview();
    }
}
