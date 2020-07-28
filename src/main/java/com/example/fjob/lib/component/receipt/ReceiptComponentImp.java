package com.example.fjob.lib.component.receipt;

import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import com.example.fjob.lib.dataset.receipt.ReceiptHistoryDataset;
import com.example.fjob.lib.mapper.receipt.ReceiptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiptComponentImp implements ReceiptComponent {

    private ReceiptMapper mapper;

    @Autowired
    public ReceiptComponentImp(ReceiptMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * insReceipt
     *
     * @param receiptDataset
     * @return
     */
    @Override
    public boolean insReceipt(ReceiptDataset receiptDataset) {
        return mapper.insReceipt(receiptDataset) > 0;
    }

    /**
     * selTransactionsAdmin
     *
     * @return List<ReceiptHistoryDataset>
     */
    @Override
    public List<ReceiptHistoryDataset> selTransactionsAdmin() {
        List<ReceiptHistoryDataset> results = mapper.selTransactionsAdmin();
        results.forEach(v -> {
            if (v.getPaymentMethod().equals("wallet")) {
                v.setType("-");
            } else if (v.getPaymentMethod().equals("add")) v.setType("+");
        });
        return results;
    }

    /**
     * selUserTransactions
     *
     * @param userName
     * @return List<ReceiptHistoryDataset>
     */
    @Override
    public List<ReceiptHistoryDataset> selUserTransactions(String userName) {
        List<ReceiptHistoryDataset> results = mapper.selUserTransactions(userName);
        results.forEach(v -> {
            if (v.getPaymentMethod().equals("wallet")) {
                v.setType("-");
            } else if (v.getPaymentMethod().equals("add")) v.setType("+");
        });
        return results;
    }
}
