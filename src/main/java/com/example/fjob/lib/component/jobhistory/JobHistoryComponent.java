package com.example.fjob.lib.component.jobhistory;

import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;

import java.util.List;

public interface JobHistoryComponent {

    /**
     * getJobHistory
     * @param bidUser
     * @return
     */
    List<JobHistoryDataset> getJobHistory(String bidUser);
}
