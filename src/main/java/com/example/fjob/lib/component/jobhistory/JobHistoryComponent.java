package com.example.fjob.lib.component.jobhistory;

import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import com.example.fjob.lib.dataset.jobhistory.JobParamDataset;
import com.example.fjob.lib.dataset.jobhistory.UserFeedback;

import java.util.List;

public interface JobHistoryComponent {

    /**
     * getJobHistory
     * @param bidUser
     * @return List<JobHistoryDataset>
     */
    List<JobHistoryDataset> getJobHistory(String bidUser);

    /**
     * addJob
     * @param paramDataset
     * @return boolean
     */
    boolean addJob(JobParamDataset paramDataset);

    /**
     * updateFeedback
     * @param paramDataset
     * @return boolean
     */
    boolean updateFeedback(JobParamDataset paramDataset);
    
    List<UserFeedback> getUserFeedback(String username);
}
