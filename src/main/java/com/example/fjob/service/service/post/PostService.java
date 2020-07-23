package com.example.fjob.service.service.post;

import com.example.fjob.lib.dataset.post.PostAdminOverviewDataset;
import com.example.fjob.lib.dataset.post.PostDetailDataset;
import com.example.fjob.lib.dataset.post.PostOverviewDataset;
import com.example.fjob.lib.dataset.post.PostParamDataset;

import java.util.List;

public interface PostService {
    /**
     * insPost
     *
     * @param paramDataset
     * @return
     */
    boolean insPost(PostParamDataset paramDataset);

    /**
     * getAllPost
     *
     * @return List<PostOverviewDataset>
     */
    List<PostOverviewDataset> getAllPost();

    /**
     * @param postId
     * @return PostDetailDataset
     */
    PostDetailDataset getPostDetail(String postId);

    /**
     * countPostByStatus
     *
     * @param status
     * @return
     */
    int countPostByStatus(String status);

    /**
     * delPost
     *
     * @param postId
     * @return
     */
    boolean delPost(String postId);

    /**
     * updPost
     *
     * @param paramDataset
     * @return
     */
    boolean updPost(PostParamDataset paramDataset);

    /**
     * searchPost
     *
     * @param title
     * @param status
     * @param tag
     * @return List<PostOverviewDataset>
     */
    List<PostOverviewDataset> searchPost(String title, String status, String tag);

    /**
     * selAdminPostOverview
     *
     * @return List<PostAdminOverviewDataset>
     */
    List<PostAdminOverviewDataset> selAdminPostOverview();
}
