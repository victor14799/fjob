package com.example.fjob.lib.component.receipt;

import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import com.example.fjob.lib.dataset.receipt.ReceiptHistoryDataset;

import java.util.List;

public interface ReceiptComponent {
    /**
     * insReceipt
     *
     * @param receiptDataset
     * @return
     */
    boolean insReceipt(ReceiptDataset receiptDataset);

    /**
     * selTransactionsAdmin
     *
     * @return List<ReceiptHistoryDataset>
     */
    List<ReceiptHistoryDataset> selTransactionsAdmin();

    /**
     * selUserTransactions
     *
     * @param userName
     * @return List<ReceiptHistoryDataset>
     */
    List<ReceiptHistoryDataset> selUserTransactions(String userName);
}
