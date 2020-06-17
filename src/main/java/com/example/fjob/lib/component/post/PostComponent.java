package com.example.fjob.lib.component.post;

import com.example.fjob.lib.dataset.post.PostDetailDataset;
import com.example.fjob.lib.dataset.post.PostOverviewDataset;
import com.example.fjob.lib.dataset.post.PostParamDataset;

import java.util.List;

public interface PostComponent {
    /**
     * insPost
     * @param paramDataset
     * @return
     */
    boolean insPost(PostParamDataset paramDataset);

    /**
     * selOverviewPost
     * @return List<PostOverviewDataset>
     */
    List<PostOverviewDataset> selOverviewPosts();

    /**
     * selDetailPost
     * @return PostDetailDataset
     */
    PostDetailDataset selDetailPost(String postId);

    /**
     * countPostByStatus
     * @param status
     * @return
     */
    int countPostByStatus(String status);

    /**
     * delPost
     * @param postId
     * @return
     */
    boolean delPost(String postId);

    /**
     * updatePost
     * @param paramDataset
     * @return
     */
    boolean updatePost(PostParamDataset paramDataset);

    /**
     * searchPost
     * @param title
     * @param status
     * @param tag
     * @return List<PostOverviewDataset>
     */
    List<PostOverviewDataset> searchPost(String title, String status, String tag);
}
