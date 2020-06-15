package com.example.fjob.service.service.bid;

import com.example.fjob.lib.dataset.bid.BidParamDataset;

public interface BidService {
    boolean insBidToPost(BidParamDataset paramDataset);

    boolean updateBid(BidParamDataset paramDataset);

    boolean delBid(BidParamDataset paramDataset);
}
