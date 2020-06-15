package com.example.fjob.lib.component.bid;

import com.example.fjob.lib.dataset.bid.BidParamDataset;

public interface BidComponent {
    /**
     * insBid
     * @param paramDataset
     * @return
     */
    boolean insBid(BidParamDataset paramDataset);

    /**
     * updateBid
     * @param paramDataset
     * @return
     */
    boolean updateBid(BidParamDataset paramDataset);

    /**
     * delBid
     * @param paramDataset
     * @return
     */
    boolean delBid(BidParamDataset paramDataset);
}
