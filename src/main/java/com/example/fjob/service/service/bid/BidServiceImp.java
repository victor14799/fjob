package com.example.fjob.service.service.bid;

import com.example.fjob.lib.component.bid.BidComponent;
import com.example.fjob.lib.dataset.bid.BidParamDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImp implements BidService{

    private BidComponent component;

    @Autowired
    public BidServiceImp(BidComponent component) {
        this.component = component;
    }

    @Override
    public boolean insBidToPost(BidParamDataset paramDataset) {
        return component.insBid(paramDataset);
    }

    @Override
    public boolean updateBid(BidParamDataset paramDataset) {
        return component.updateBid(paramDataset);
    }

    @Override
    public boolean delBid(BidParamDataset paramDataset) {
        return component.delBid(paramDataset);
    }
}
