package com.example.fjob.service.controller.jobhistory;

import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import com.example.fjob.service.service.jobhistory.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fjob/v1")
@Validated
public class JobHistoryController {
    private JobHistoryService service;

    @Autowired
    public JobHistoryController(JobHistoryService service) {
        this.service = service;
    }

    @GetMapping("/jobs-history/{bidUser}")
    List<JobHistoryDataset> selJobHistory(@PathVariable("bidUser") String bidUser){
        return service.getJobHistory(bidUser);
    }

}
