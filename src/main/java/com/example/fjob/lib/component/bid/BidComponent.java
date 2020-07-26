package com.example.fjob.lib.component.bid;

import com.example.fjob.lib.dataset.bid.BidParamDataset;
import com.example.fjob.lib.dataset.bid.CommentDataset;

import java.util.List;

public interface BidComponent {
    /**
     * selComment
     *
     * @param postId
     * @return
     */
    List<CommentDataset> selComment(String postId);

    /**
     * insBid
     *
     * @param paramDataset
     * @return
     */
    boolean insBid(BidParamDataset paramDataset);

    /**
     * updateBid
     *
     * @param paramDataset
     * @return
     */
    boolean updateBid(BidParamDataset paramDataset);

    /**
     * delBid
     *
     * @param paramDataset
     * @return
     */
    boolean delBid(BidParamDataset paramDataset);

    /**
     * postId
     * @param postId
     * @param bidUser
     * @return String
     */
    String selPrice(String postId, String bidUser);
}
