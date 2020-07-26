package com.example.fjob.service.service.receipt;

import com.example.fjob.lib.component.account.AccountComponent;
import com.example.fjob.lib.component.bid.BidComponent;
import com.example.fjob.lib.component.jobhistory.JobHistoryComponent;
import com.example.fjob.lib.component.post.PostComponent;
import com.example.fjob.lib.component.receipt.ReceiptComponent;
import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.jobhistory.JobParamDataset;
import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImp implements ReceiptService {

    private ReceiptComponent receiptComponent;

    private AccountComponent accountComponent;

    private PostComponent postComponent;

    private JobHistoryComponent jobHistoryComponent;

    private BidComponent bidComponent;

    @Autowired
    public ReceiptServiceImp(ReceiptComponent receiptComponent,
                             AccountComponent accountComponent,
                             PostComponent postComponent,
                             JobHistoryComponent jobHistoryComponent,
                             BidComponent bidComponent) {
        this.receiptComponent = receiptComponent;
        this.accountComponent = accountComponent;
        this.postComponent = postComponent;
        this.jobHistoryComponent = jobHistoryComponent;
        this.bidComponent = bidComponent;
    }


    @Override
    public boolean createNewReceipt(ReceiptDataset receiptDataset) {
        boolean result = receiptComponent.insReceipt(receiptDataset);
        if (result) {
            JobParamDataset job = new JobParamDataset();
            job.setPostId(receiptDataset.getJobId());
            job.setBidUser(receiptDataset.getBidUserName());
            String price = bidComponent.selPrice(receiptDataset.getJobId(),receiptDataset.getBidUserName());
            job.setPrice(price);
            // Job is in progress
            job.setStatus("0");
            // No feedback
            job.setFeedback("0");
            // No comment
            job.setComment("");

            AccountDataset user = accountComponent.getAllInfor(receiptDataset.getUserName());
            if (receiptDataset.getPayment().equals("wallet")) {

                if (user != null) {
                    // Convert fee to double
                    double fee = Double.parseDouble(receiptDataset.getFee());
                    // Convert balance of account to double
                    double accountBalance = Double.parseDouble(user.getBalance());
                    //Update new balance minus fee
                    double newBalance = (accountBalance - fee);
                    //Convert double to String
                    String balanceStr = "" + newBalance;

                    //Update account balance
                    accountComponent.updateBalance(balanceStr, receiptDataset.getUserName());

                    //Closed post
                    postComponent.updatePostStatus(receiptDataset.getUserName(), receiptDataset.getJobId(), "2");

                }
            } else if (receiptDataset.getPayment().equals("add")) {
                if (user != null) {
                    // Convert fee to double
                    double amount = Double.parseDouble(receiptDataset.getFee());
                    // Convert balance of account to double
                    double accountBalance = Double.parseDouble(user.getBalance());
                    //Update new balance minus fee
                    double newBalance = (accountBalance + amount);
                    //Convert double to String
                    String balanceStr = "" + newBalance;

                    return accountComponent.updateBalance(balanceStr, receiptDataset.getUserName()) > 0;
                }
            }


            //Create new job for account
            jobHistoryComponent.addJob(job);
            //Closed post
            postComponent.updatePostStatus(receiptDataset.getUserName(), receiptDataset.getJobId(), "2");
        }

        return result;
    }
}
