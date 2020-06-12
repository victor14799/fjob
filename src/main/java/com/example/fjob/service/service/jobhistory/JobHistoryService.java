package com.example.fjob.service.service.jobhistory;

import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;

import java.util.List;

public interface JobHistoryService {
    List<JobHistoryDataset> getJobHistory(String bidUser);
}
