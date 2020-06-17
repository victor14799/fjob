package com.example.fjob.service.service.post;

import com.example.fjob.lib.component.post.PostComponent;
import com.example.fjob.lib.dataset.post.PostDetailDataset;
import com.example.fjob.lib.dataset.post.PostOverviewDataset;
import com.example.fjob.lib.dataset.post.PostParamDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService{

    private PostComponent component;

    @Autowired
    public PostServiceImp(PostComponent component) {
        this.component = component;
    }

    @Override
    public boolean insPost(PostParamDataset paramDataset) {
        return component.insPost(paramDataset);
    }

    /**
     * getAllPost
     *
     * @return
     */
    @Override
    public List<PostOverviewDataset> getAllPost() {
        return component.selOverviewPosts();
    }

    /**
     * @param postId
     * @return PostDetailDataset
     */
    @Override
    public PostDetailDataset getPostDetail(String postId) {
        return component.selDetailPost(postId);
    }

    /**
     * countPostByStatus
     *
     * @param status
     * @return
     */
    @Override
    public int countPostByStatus(String status) {
        return component.countPostByStatus(status);
    }

    /**
     * delPost
     *
     * @param postId
     * @return
     */
    @Override
    public boolean delPost(String postId) {
        return component.delPost(postId);
    }

    /**
     * updPost
     *
     * @param paramDataset
     * @return
     */
    @Override
    public boolean updPost(PostParamDataset paramDataset) {
        return component.updatePost(paramDataset);
    }

    /**
     * searchPost
     *
     * @param title
     * @param status
     * @param tag
     * @return List<PostOverviewDataset>
     */
    @Override
    public List<PostOverviewDataset> searchPost(String title, String status, String tag) {
        return component.searchPost(title, status, tag);
    }
}
