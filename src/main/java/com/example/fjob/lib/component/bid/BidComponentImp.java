package com.example.fjob.lib.component.bid;

import com.example.fjob.lib.dataset.bid.BidParamDataset;
import com.example.fjob.lib.dataset.bid.CommentDataset;
import com.example.fjob.lib.mapper.bid.BidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BidComponentImp implements BidComponent {

    private BidMapper mapper;

    @Autowired
    public BidComponentImp(BidMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * selComment
     *
     * @param postId
     * @return
     */
    @Override
    public List<CommentDataset> selComment(String postId) {
        return mapper.selComment(postId);
    }

    @Override
    public boolean insBid(BidParamDataset paramDataset) {
        if(this.isExist(paramDataset)){
            return false;
        }
        return mapper.insBidToPost(paramDataset) > 0;
    }

    @Override
    public boolean updateBid(BidParamDataset paramDataset) {
        if(this.isExist(paramDataset)){
            return mapper.updateBid(paramDataset) > 0;
        }
        return false;
    }

    @Override
    public boolean delBid(BidParamDataset paramDataset) {
        if(this.isExist(paramDataset)){
            return mapper.deleteBid(paramDataset) > 0;
        }
        return false;
    }

    private boolean isExist(BidParamDataset paramDataset){
        return mapper.selBidUser(paramDataset) > 0;
    }
}
