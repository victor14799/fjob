package com.example.fjob.service.controller.post;

import com.example.fjob.lib.dataset.post.PostDetailDataset;
import com.example.fjob.lib.dataset.post.PostOverviewDataset;
import com.example.fjob.lib.dataset.post.PostParamDataset;
import com.example.fjob.service.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "fjob/v1/post")
public class PostController {
    private PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @RequestMapping(value = "/createNewPost", method = RequestMethod.POST)
    public boolean insPost(@RequestBody  PostParamDataset paramDataset){
        return service.insPost(paramDataset);
    }

    @GetMapping("/newsfeed")
    public List<PostOverviewDataset> getAllPost(){
        return service.getAllPost();
    }

    @GetMapping("/{postId}")
    public PostDetailDataset getPostDetail(@PathVariable("postId") String postId){
        return service.getPostDetail(postId);
    }

    @GetMapping("/count")
    public int countPost(@RequestParam("status") String status){
        return service.countPostByStatus(status);
    }

    @DeleteMapping("/{postId}/del")
    public boolean delPost(@PathVariable("postId") String postId){
        return service.delPost(postId);
    }

    @PutMapping("/{postId}/upd")
    public boolean updPost( @PathVariable("postId") String postId, @RequestBody  PostParamDataset paramDataset){
        return service.updPost(paramDataset);
    }

    @GetMapping("/searchBy")
    public List<PostOverviewDataset> searchPost(@RequestParam("title") String title, @RequestParam("status") String status, @RequestParam("tag") String tag){
        return service.searchPost(title, status, tag);
    }
}
