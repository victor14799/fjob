package com.example.fjob.service.controller.jobhistory;

import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import com.example.fjob.lib.dataset.jobhistory.JobParamDataset;
import com.example.fjob.lib.dataset.jobhistory.UserFeedback;
import com.example.fjob.service.service.jobhistory.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fjob/v1/jobs-history")
@Validated
public class JobHistoryController {
    private JobHistoryService service;

    @Autowired
    public JobHistoryController(JobHistoryService service) {
        this.service = service;
    }

    @GetMapping("/{bidUser}")
    List<JobHistoryDataset> selJobHistory(@PathVariable("bidUser") String bidUser){
        return service.getJobHistory(bidUser);
    }
    
    @GetMapping("/user/{username}")
    List<JobHistoryDataset> selUserJobHistory(@PathVariable("username") String username){
        return service.getUserJobHistory(username);
    }
    
    @GetMapping("/feedbacks/{username}")
    List<UserFeedback> getUseFeedback(@PathVariable("username") String username){
        return service.getUserFeedback(username);
    }
    
    @GetMapping("/pick/{postId}")
    AccountDataset getPickUser(@PathVariable("postId") String postId){
        return service.getPickUser(postId);
    }
    
    
    @PutMapping("/update")
    boolean updateFeedback(@RequestBody JobParamDataset paramDataset){
        return service.updateFeedback(paramDataset);
    }
}
