package com.example.fjob.lib.mapper.jobhistory;

import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import com.example.fjob.lib.dataset.jobhistory.JobParamDataset;
import com.example.fjob.lib.dataset.jobhistory.UserFeedback;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobHistoryMapper {

    @Select("SELECT " + 
    		"  T1.TITLE AS title,  " + 
    		"	T0.POST_ID as postId,	" + 
    		"  T0.bid_user AS userName,  " + 
    		"  t2.first_name as firstName," + 
    		"  t2.last_name as lastName," + 
    		"  T0.PRICE  AS price,  " + 
    		"  T0.FEEDBACK AS feedback,  " + 
    		"  T0.COMMENT AS comment,  " + 
    		"  T0.STATUS AS status,  " + 
    		"  t3.due_date as dueDate " + 
    		"	FROM JOB_HISTORY T0  " + 
    		"	INNER JOIN POST T1  " + 
    		"   	ON T0.POST_ID = T1.POST_ID	" + 
    		"	inner join account t2	" + 
    		"  	on t0.bid_user = t2.user_name	" + 
    		"	inner join bid t3" + 
    		"	on 	t3.post_id = t1.post_id and " + 
    		"		t3.bid_user =t0.bid_user " + 
    		"	WHERE t0.bid_user = #{bidUser}	")
    List<JobHistoryDataset> getJobHistory(@Param("bidUser" ) String bidUser);
    
    @Select("SELECT " + 
    		"  T1.TITLE AS title,  " + 
    		"	T0.POST_ID as postId,	" + 
    		"  T0.bid_user AS userName,  " + 
    		"  t2.first_name as firstName," + 
    		"  t2.last_name as lastName," + 
    		"  T0.PRICE  AS price,  " + 
    		"  T0.FEEDBACK AS feedback,  " + 
    		"  T0.COMMENT AS comment,  " + 
    		"  T0.STATUS AS status,  " + 
    		"  t3.due_date as dueDate " + 
    		"	FROM JOB_HISTORY T0  " + 
    		"	INNER JOIN POST T1  " + 
    		"   	ON T0.POST_ID = T1.POST_ID	" + 
    		"	inner join account t2	" + 
    		"  	on t0.bid_user = t2.user_name " + 
    		"	inner join bid t3" + 
    		"	on 	t3.post_id = t1.post_id and " + 
    		"		t3.bid_user =t0.bid_user " + 
    		"	WHERE T1.USER_NAME = #{username}	")
    List<JobHistoryDataset> getUserJobHistory(@Param("username" ) String username);

    @Insert("INSERT INTO JOB_HISTORY " +
            "(POST_ID, " +
            "BID_USER, " +
            "PRICE, " +
            "STATUS," +
            "FEEDBACK, " +
            "INS_DATE, " +
            "UPD_DATE) " +
            "   VALUES" +
            "(#{postId}, " +
            "#{bidUser}, " +
            "#{price} , " +
            "#{status} , " +
            "#{feedback} ," +
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
    		"	where bid_user = #{username} " +
			"	AND jh.STATUS = '2' ")
    List<UserFeedback> selUserFeedback(@Param("username")String username);
    
    @Select("Select bid_user from job_history where post_id = #{post_id}")
    String getPickUser(String postId);
}
