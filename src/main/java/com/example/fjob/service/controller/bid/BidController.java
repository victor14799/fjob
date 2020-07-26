package com.example.fjob.service.controller.bid;

import com.example.fjob.lib.dataset.bid.BidParamDataset;
import com.example.fjob.lib.dataset.bid.CommentDataset;
import com.example.fjob.service.service.bid.BidService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fjob/v1/bid")
public class BidController {
    private BidService service;

    @Autowired
    public BidController(BidService service) {
        this.service = service;
    }

    @GetMapping("/{postId}")
    public List<CommentDataset> getComment(@PathVariable("postId") String postId){
        return service.getComment(postId);
    }

    @PostMapping("/{postId}")
    public boolean addBid(@RequestBody BidParamDataset paramDataset) {
        return service.insBidToPost(paramDataset);
    }

    @PutMapping("/{postId}/updateBid")
    public boolean updateBid(@RequestBody BidParamDataset paramDataset) {
        return service.updateBid(paramDataset);
    }

    @RequestMapping(value ="/{postId}/delBid", method = RequestMethod.DELETE)
    public boolean delBid(@RequestBody BidParamDataset paramDataset) {
        return service.delBid(paramDataset);
    }
    
    @GetMapping("/pick")
    public CommentDataset getPickComment(@RequestParam("postId") String postId, @RequestParam("bidUser") String bidUser){
        return service.getPickComment(postId, bidUser);
    }
}
