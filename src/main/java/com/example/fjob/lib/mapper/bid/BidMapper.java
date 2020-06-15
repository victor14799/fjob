package com.example.fjob.lib.mapper.bid;

import com.example.fjob.lib.dataset.bid.BidParamDataset;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BidMapper {
    @Insert("INSERT INTO BID " +
            "(POST_ID,  " +
            "BID_USER,  " +
            "PRICE,  " +
            "DUE_DATE,  " +
            "STATUS,  " +
            "UPD_DATE,  " +
            "INS_DATE) " +
            "VALUES" +
            "(#{postId}, " +
            "#{bidUser}, " +
            "#{price}, " +
            "#{dueDate}, " +
            "#{status}, " +
            "CURRENT_TIMESTAMP, " +
            "CURRENT_TIMESTAMP)")
    int insBidToPost(BidParamDataset paramDataset);

    @Select("SELECT COUNT(1) " +
            "FROM " +
            "BID " +
            "WHERE " +
            "    BID_USER = #{bidUser} " +
            "    AND POST_ID = #{postId} ")
    int selBidUser(BidParamDataset paramDataset);

    @Update("UPDATE BID " +
            "SET PRICE= #{price},  " +
            "DUE_DATE= #{dueDate},  " +
            "STATUS=#{status},  " +
            "UPD_DATE= CURRENT_TIMESTAMP  " +
            "  WHERE POST_ID = #{postId}  " +
            "  AND BID_USER = #{bidUser} ")
    int updateBid(BidParamDataset paramDataset);

    @Delete("DELETE "+
            "FROM " +
            "BID " +
            "WHERE " +
            "    BID_USER = #{bidUser} " +
            "    AND POST_ID = #{postId} ")
    int deleteBid(BidParamDataset paramDataset);
}
