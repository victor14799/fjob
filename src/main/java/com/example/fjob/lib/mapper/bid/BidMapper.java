package com.example.fjob.lib.mapper.bid;

import com.example.fjob.lib.dataset.bid.BidParamDataset;
import com.example.fjob.lib.dataset.bid.CommentDataset;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
    
    @Select("SELECT  " +
            " T0.BID_USER AS bidUser,  " +
            " T1.LAST_NAME || ' ' || T1.FIRST_NAME AS fullName, " +
            " COALESCE(T1.IMG,'') AS img, " +
            " T0.PRICE AS price, " +
            " T0.DUE_DATE AS dueDate, " +
            " T0.INS_DATE AS insDate" +
            " FROM BID T0 " +
            " INNER JOIN ACCOUNT T1 " +
            " ON T0.BID_USER  = T1.USER_NAME  " +
            " WHERE POST_ID = #{postId} ")
    List<CommentDataset> selComment(@Param("postId") String postId);

    @Select("SELECT PRICE " +
            "FROM BID  " +
            "WHERE BID_USER =#{bidUser} " +
            "AND POST_ID =#{postId} ")
    String selPrice(@Param("postId") String postId,@Param("bidUser") String bidUser );
}
