package com.example.fjob.lib.component.receipt;

import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import com.example.fjob.lib.mapper.receipt.ReceiptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
