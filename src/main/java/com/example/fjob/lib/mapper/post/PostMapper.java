package com.example.fjob.lib.mapper.post;

import com.example.fjob.lib.dataset.post.PostDetailDataset;
import com.example.fjob.lib.dataset.post.PostOverviewDataset;
import com.example.fjob.lib.dataset.post.PostParamDataset;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    @Insert("INSERT INTO POST" +
            "(POST_ID, " +
            "USER_NAME, " +
            "TITLE, " +
            "BUDGET, " +
            "CONTENT, " +
            "TAG, " +
            "STATUS, " +
            "START_DATE, " +
            "END_DATE, " +
            "INS_DATE, " +
            "UPD_DATE) " +
            "VALUES" +
            "(#{postId}, " +
            "#{username}, " +
            "#{title}, " +
            "#{budget}, " +
            "#{content}, " +
            "#{tag}, " +
            "#{status}, " +
            "#{startDate}, " +
            "#{endDate}, " +
            "CURRENT_TIMESTAMP, " +
            "CURRENT_TIMESTAMP)")
    int insPost(PostParamDataset paramDataset);

    @Select("SELECT " +
            "T0.POST_ID AS postID,   " +
            "T1.LAST_NAME || ' ' || T1.FIRST_NAME  AS fullName,   "
            + "T0.USER_NAME AS userName," +
            "T0.TITLE AS title,   " +
            "T0.CONTENT AS content,  " +
            "T0.BUDGET AS budget,   " +
            "T0.TAG AS tag,   " +
            "T0.STATUS AS status,   " +
            "T0.INS_DATE AS insDate " +
            "FROM POST T0  " +
            "INNER JOIN ACCOUNT T1  " +
            "ON " +
            "   T1.USER_NAME = T0.USER_NAME   " +
            "ORDER BY " +
            "   T0.INS_DATE DESC")
    List<PostOverviewDataset> selOverviewPost();

    @Select("SELECT " +
            "T0.POST_ID AS postId, " +
            "T0.USER_NAME AS username,  " +
            "T1.LAST_NAME || ' ' || T1.FIRST_NAME  AS fullName,    " +
            "T0.TITLE AS title, " +
            "T1.img AS imgUrl,  " +
            "T0.BUDGET AS budget, " +
            "T0.CONTENT AS content, " +
            "COALESCE(T0.TAG,'') AS tag, " +
            "T0.STATUS AS status, " +
            "T0.START_DATE AS startDate, " +
            "T0.END_DATE AS endDate, " +
            "T0.INS_DATE AS insDate, " +
            "T0.UPD_DATE AS updDate   " +
            "FROM POST T0  " +
            "INNER JOIN ACCOUNT T1  " +
            "ON T0.USER_NAME = T1.USER_NAME  " +
            "WHERE POST_ID = #{postId}")
    PostDetailDataset selPostDetail(@Param("postId") String postId);

    @Select("SELECT COUNT(1) " +
            "FROM POST " +
            "WHERE status = #{status}")
    int countPostByStatus(@Param("status") String status);

    @Delete("DELETE " +
            "FROM POST " +
            "WHERE POST_ID = #{postId}")
    int delPost(@Param("postId") String postId);

    @Update("UPDATE POST    " +
            "SET " +
            "TITLE = #{title},    " +
            "BUDGET = #{budget},     " +
            "CONTENT = #{content},     " +
            "TAG = #{tag},     " +
            "STATUS = #{status},     " +
            "START_DATE = #{startDate},     " +
            "END_DATE = #{endDate},    " +
            "UPD_DATE = CURRENT_TIMESTAMP    " +
            "WHERE POST_ID = #{postId} " +
            "AND USER_NAME = #{username}")
    int updPost(PostParamDataset paramDataset);
}
