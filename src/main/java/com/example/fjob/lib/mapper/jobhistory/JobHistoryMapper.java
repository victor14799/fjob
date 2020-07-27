package com.example.fjob.lib.mapper.jobhistory;

import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import com.example.fjob.lib.dataset.jobhistory.JobParamDataset;
import com.example.fjob.lib.dataset.jobhistory.UserFeedback;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobHistoryMapper {

    @Select("SELECT " +
            "  T1.TITLE AS title,  "
            + "	T0.POST_ID as postId,	" +
            "  T1.USER_NAME AS userName,  " +
            "  T0.PRICE  AS price,  " +
            "  T0.FEEDBACK AS feedback,  " +
            "  T0.COMMENT AS comment,  " +
            "  T0.STATUS AS status,  " +
            "  T1.START_DATE AS startDate,  " +
            "  T1.END_DATE AS endDate  " +
            "FROM JOB_HISTORY T0  " +
            "INNER JOIN POST T1  " +
            "   ON T0.POST_ID = T1.POST_ID " +
            "WHERE BID_USER = #{bidUser}")
    List<JobHistoryDataset> getJobHistory(@Param("bidUser" ) String bidUser);
    
    @Select("SELECT " +
            "  T1.TITLE AS title,  " 
            + "	T0.POST_ID as postId,	" +
            "  T1.USER_NAME AS userName,  " +
            "  T0.PRICE  AS price,  " +
            "  T0.FEEDBACK AS feedback,  " +
            "  T0.COMMENT AS comment,  " +
            "  T0.STATUS AS status,  " +
            "  T1.START_DATE AS startDate,  " +
            "  T1.END_DATE AS endDate  " +
            "FROM JOB_HISTORY T0  " +
            "INNER JOIN POST T1  " +
            "   ON T0.POST_ID = T1.POST_ID " +
            "WHERE T1.USER_NAME = #{username}")
    List<JobHistoryDataset> getUserJobHistory(@Param("username" ) String username);

    @Insert("INSERT INTO JOB_HISTORY " +
            "(POST_ID, " +
            "BID_USER, " +
            "PRICE, " +
            "STATUS, " +
            "INS_DATE, " +
            "UPD_DATE) " +
            "   VALUES" +
            "(#{postId}, " +
            "#{bidUser}, " +
            "#{price} , " +
            "#{status} , " +
            "CURRENT_TIMESTAMP, " +
            "CURRENT_TIMESTAMP) ")
    int addJob(JobParamDataset paramDataset);

    @Update("UPDATE JOB_HISTORY  " +
            "SET FEEDBACK= #{feedback}, " +
            "COMMENT=#{comment}, " +
            "STATUS=#{status}, " +
            "UPD_DATE = CURRENT_TIMESTAMP  " +
            "WHERE " +
            "   POST_ID=#{postId} " +
            "   AND BID_USER=#{bidUser}")
    int updateFeedback(JobParamDataset paramDataset);
    
    @Select("select " + 
    		"	jh.feedback, " + 
    		"	jh.comment, " + 
    		"	jh.ins_date as feedbackDate, " + 
    		"	p.title,	" + 
    		"	a.first_name || ' ' || a.last_name as fullname	,"
    		+ " a.img as img" + 
    		"	from job_history jh	" + 
    		"	inner join post p using(post_id)	" + 
    		"	inner join account a on p.user_name = a.user_name " + 
    		"	where bid_user = #{username}")
    List<UserFeedback> selUserFeedback(@Param("username")String username);
    
    @Select("Select bid_user from job_history where post_id = #{post_id}")
    String getPickUser(String postId);
}
