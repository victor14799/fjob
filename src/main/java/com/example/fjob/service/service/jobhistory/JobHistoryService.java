package com.example.fjob.service.service.jobhistory;

import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import com.example.fjob.lib.dataset.jobhistory.JobParamDataset;
import com.example.fjob.lib.dataset.jobhistory.UserFeedback;

import java.util.List;

public interface JobHistoryService {
    /**
     * getJobHistory
     * @param bidUser
     * @return List<JobHistoryDataset>
     */
    List<JobHistoryDataset> getJobHistory(String bidUser);
    
    List<UserFeedback> getUserFeedback(String username);
    List<JobHistoryDataset> getUserJobHistory(String username);
}
