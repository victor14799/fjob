package com.example.fjob.service.service.receipt;

import com.example.fjob.lib.component.receipt.ReceiptComponent;
import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImp implements ReceiptService{

    private ReceiptComponent component;

    @Autowired
    public ReceiptServiceImp(ReceiptComponent component) {
        this.component = component;
    }

    @Override
    public boolean createNewReceipt(ReceiptDataset receiptDataset) {
        return component.insReceipt(receiptDataset);
    }
}
