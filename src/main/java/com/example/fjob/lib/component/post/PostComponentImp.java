package com.example.fjob.lib.component.post;

import com.example.fjob.common.CommonUtils;
import com.example.fjob.lib.dataset.post.PostAdminOverviewDataset;
import com.example.fjob.lib.mapper.post.PostMapper;
import com.example.fjob.lib.dataset.post.PostDetailDataset;
import com.example.fjob.lib.dataset.post.PostOverviewDataset;
import com.example.fjob.lib.dataset.post.PostParamDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostComponentImp implements PostComponent {
    private PostMapper mapper;

    private final String STATUS_OPEN_STR = "0";


    @Autowired
    public PostComponentImp(PostMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * insPost
     *
     * @param paramDataset
     * @return
     */
    @Override
    public boolean insPost(PostParamDataset paramDataset) {
        if (paramDataset.getPostId() == null || paramDataset.getPostId().isEmpty()) {
            String postId = CommonUtils.randomID();
            if (postId.isEmpty()) {
                return false;
            }
            paramDataset.setPostId(postId);
        }
        if (paramDataset.getStatus() == null || paramDataset.getPostId().isEmpty()) {
            paramDataset.setStatus(STATUS_OPEN_STR);
        }
        return mapper.insPost(paramDataset) > 0;
    }

    /**
     * selOverviewPost
     *
     * @return
     */
    @Override
    public List<PostOverviewDataset> selOverviewPosts() {
        List<PostOverviewDataset> results = mapper.selOverviewPost();
        return results;
    }

    /**
     * selDetailPost
     *
     * @return PostDetailDataset
     */
    @Override
    public PostDetailDataset selDetailPost(String postId) {
        PostDetailDataset results = mapper.selPostDetail(postId);
        List<String> tagList = new ArrayList<>();
        if (results.getTag() != null) {
            if (results.getTag().trim() != "") {
                String[] tags = results.getTag().split(",");

                for (int i = 0; i < tags.length; i++) {
                    tagList.add(tags[i].trim());
                }

            }

        }
        results.setSkillLists(tagList);
        return results;
    }

    /**
     * countPostByStatus
     *
     * @param status
     * @return
     */
    @Override
    public int countPostByStatus(String status) {
        return mapper.countPostByStatus(status);
    }

    /**
     * delPost
     *
     * @param postId
     * @return
     */
    @Override
    public boolean delPost(String postId) {
        return mapper.delPost(postId) > 0;
    }

    /**
     * updatePost
     *
     * @param paramDataset
     * @return
     */
    @Override
    public boolean updatePost(PostParamDataset paramDataset) {
        return mapper.updPost(paramDataset) > 0;
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
        List<PostOverviewDataset> listAllPost = this.selOverviewPosts();
        List<PostOverviewDataset> results = new ArrayList<>();

        if (title != null && !title.isEmpty()) {
            results = listAllPost
                    .stream()
                    .filter(index ->
                            index.getTitle().toLowerCase().contains(title.trim().toLowerCase()))
                    .collect(Collectors.toList());
            if (results != null && !results.isEmpty()) {
                if (status != null && !status.isEmpty()) {
                    results = results
                            .stream()
                            .filter(index -> index.getStatus().contains(status))
                            .collect(Collectors.toList());
                }
                if (tag != null && !tag.isEmpty()) {
                	if (tag.contains(",")) {
                		String[] tags = tag.split(",");
                		for (String value : tags) {
                			results = results
                                    .stream()
                                    .filter((index -> index.getTag() != null && index.getTag().contains(value.trim())))
                                    .collect(Collectors.toList());
                		}
                	} else {
                		results = results
                                .stream()
                                .filter((index -> index.getTag() != null && index.getTag().contains(tag)))
                                .collect(Collectors.toList());
                	}
                	
                    
                }
            }
        }
        return results;
    }

    /**
     * selAdminOverview
     * @return List<PostAdminOverviewDataset>
     */
    @Override
    public List<PostAdminOverviewDataset> selAdminOverview() {
        return mapper.selAdminOverview();
    }
}
