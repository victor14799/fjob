package com.example.fjob.service.controller.receipt;

import com.example.fjob.lib.dataset.receipt.ReceiptDataset;
import com.example.fjob.service.service.receipt.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "fjob/v1/receipt")
public class ReceiptController {
    ReceiptService service;

    @Autowired
    public ReceiptController(ReceiptService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Boolean> insNewReceipt(@RequestBody ReceiptDataset receiptDataset) {
        boolean result = service.createNewReceipt(receiptDataset);
        if (result) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
