package com.example.fjob.service.service.receipt;

import com.example.fjob.lib.component.account.AccountComponent;
import com.example.fjob.lib.component.post.PostComponent;
import com.example.fjob.lib.component.receipt.ReceiptComponent;
import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImp implements ReceiptService {

    private ReceiptComponent receiptComponent;

    private AccountComponent accountComponent;

    private PostComponent postComponent;

    @Autowired
    public ReceiptServiceImp(ReceiptComponent receiptComponent, AccountComponent accountComponent, PostComponent postComponent) {
        this.receiptComponent = receiptComponent;
        this.accountComponent = accountComponent;
        this.postComponent = postComponent;
    }


    @Override
    public boolean createNewReceipt(ReceiptDataset receiptDataset) {
        boolean result = receiptComponent.insReceipt(receiptDataset);
        if (result) {
            if (receiptDataset.getPayment().equals("wallet")) {
                AccountDataset user = accountComponent.getAllInfor(receiptDataset.getUserName());
                if (user != null) {
                    // Convert fee to double
                    double fee = Double.parseDouble(receiptDataset.getFee());
                    // Convert balance of account to double
                    double accountBalance = Double.parseDouble(user.getBalance());
                    //Update new balance minus fee
                    double newBalance = (accountBalance - fee);
                    //Convert double to String
                    String balanceStr = "" + newBalance;

                    boolean updateSuccess = accountComponent.updateBalance(balanceStr, receiptDataset.getUserName()) > 0;

                    //Closed post
                    postComponent.updatePostStatus(receiptDataset.getUserName(), receiptDataset.getJobId(), "2");
                    return updateSuccess;
                }
                return false;
            }
        }
        //Closed post
        postComponent.updatePostStatus(receiptDataset.getUserName(), receiptDataset.getJobId(), "2");
        return result;
    }
}
