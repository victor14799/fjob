package com.example.fjob.service.service.receipt;

import com.example.fjob.lib.component.account.AccountComponent;
import com.example.fjob.lib.component.receipt.ReceiptComponent;
import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImp implements ReceiptService {

    private ReceiptComponent receiptComponent;

    private AccountComponent accountComponent;

    @Autowired
    public ReceiptServiceImp(ReceiptComponent receiptComponent, AccountComponent accountComponent) {
        this.receiptComponent = receiptComponent;
        this.accountComponent = accountComponent;
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

                    return accountComponent.updateBalance(balanceStr, receiptDataset.getUserName()) > 0;
                }
                return false;
            }
        }
        return result;
    }
}
