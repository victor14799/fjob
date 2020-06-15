package com.example.fjob.service.controller.bid;

import com.example.fjob.lib.dataset.bid.BidParamDataset;
import com.example.fjob.service.service.bid.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fjob/v1/bid")
public class BidController {
    private BidService service;

    @Autowired
    public BidController(BidService service) {
        this.service = service;
    }

    @PostMapping("/{postId}")
    public boolean addBid(@RequestBody BidParamDataset paramDataset) {
        return service.insBidToPost(paramDataset);
    }

    @PutMapping("/{postId}/updateBid")
    public boolean updateBid(@RequestBody BidParamDataset paramDataset) {
        return service.updateBid(paramDataset);
    }

    @DeleteMapping("/{postId}/delBid")
    public boolean delBid(@RequestBody BidParamDataset paramDataset) {
        return service.delBid(paramDataset);
    }
}
