package com.example.fjob.service.service.bid;

import com.example.fjob.lib.dataset.bid.BidParamDataset;
import com.example.fjob.lib.dataset.bid.CommentDataset;

import java.util.List;

public interface BidService {
    List<CommentDataset> getComment(String postId);

    boolean insBidToPost(BidParamDataset paramDataset);

    boolean updateBid(BidParamDataset paramDataset);

    boolean delBid(BidParamDataset paramDataset);
}
