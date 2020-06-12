package com.example.fjob.service.service.jobhistory;

import com.example.fjob.lib.component.jobhistory.JobHistoryComponent;
import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class JobHistoryServiceImp implements  JobHistoryService{
    JobHistoryComponent component;

    @Autowired
    public JobHistoryServiceImp(JobHistoryComponent component) {
        this.component = component;
    }

    @Override
    public List<JobHistoryDataset> getJobHistory(@RequestParam String bidUser) {
        return component.getJobHistory(bidUser);
    }
}
