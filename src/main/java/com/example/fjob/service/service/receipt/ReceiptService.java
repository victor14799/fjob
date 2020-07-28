package com.example.fjob.service.service.receipt;

import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import com.example.fjob.lib.dataset.receipt.ReceiptHistoryDataset;

import java.util.List;

public interface ReceiptService {

    boolean createNewReceipt(ReceiptDataset receiptDataset);

    List<ReceiptHistoryDataset> getTransactionsAdmin();

    List<ReceiptHistoryDataset> getUserTransactions(String userName);
}
