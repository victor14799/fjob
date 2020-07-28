package com.example.fjob.service.controller.admin;

import com.example.fjob.lib.dataset.post.PostAdminOverviewDataset;
import com.example.fjob.lib.dataset.receipt.ReceiptHistoryDataset;
import com.example.fjob.service.datamodel.AdminDashboardDatamodel;
import com.example.fjob.service.service.account.AccountService;
import com.example.fjob.service.service.post.PostService;
import com.example.fjob.service.service.receipt.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fjob/v1/admin")
public class AdminController {
    private AccountService accountService;

    private PostService postService;

    private ReceiptService receiptService;

    @Autowired
    public AdminController(AccountService accountService, PostService postService, ReceiptService receiptService) {
        this.accountService = accountService;
        this.postService = postService;
        this.receiptService = receiptService;
    }

    @GetMapping("/dashboard")
    public AdminDashboardDatamodel getAdminDashboard() {
        return accountService.getAdminDashboard();
    }

    @GetMapping("/posts")
    public List<PostAdminOverviewDataset> getAdminPostOverview() {
        return postService.selAdminPostOverview();
    }

    @DeleteMapping("/posts/{postId}")
    public boolean deletePost(@PathVariable String postId) {
        return postService.delPost(postId);
    }

    @PutMapping("/users/{userName}/enable")
    public boolean enableAccount(@PathVariable String userName) {
        return accountService.enableAccount(userName) > 0;
    }

    @PutMapping("/users/{userName}/disable")
    public boolean disableAccount(@PathVariable String userName) {
        return accountService.disableAccount(userName) > 0;
    }

    @GetMapping("/receipts")
    public List<ReceiptHistoryDataset> getTransactions(){
        return receiptService.getTransactionsAdmin();
    }

}
