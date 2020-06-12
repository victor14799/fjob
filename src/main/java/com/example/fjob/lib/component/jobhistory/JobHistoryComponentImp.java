package com.example.fjob.lib.component.jobhistory;

import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import com.example.fjob.lib.mapper.jobhistory.JobHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobHistoryComponentImp implements JobHistoryComponent{

    private JobHistoryMapper mapper;

    @Autowired
    public JobHistoryComponentImp(JobHistoryMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<JobHistoryDataset> getJobHistory(String bidUser) {
        return mapper.getJobHistory(bidUser);
    }
}
