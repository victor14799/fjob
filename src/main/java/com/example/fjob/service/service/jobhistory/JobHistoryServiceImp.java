package com.example.fjob.service.service.jobhistory;

import com.example.fjob.lib.component.jobhistory.JobHistoryComponent;
import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import com.example.fjob.lib.dataset.jobhistory.JobParamDataset;
import com.example.fjob.lib.dataset.jobhistory.UserFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class JobHistoryServiceImp implements  JobHistoryService{
    /**
     * JobHistoryComponent
     */
    JobHistoryComponent component;

    /**
     * Constructor for JobHistoryServiceImp
     * @param component
     */
    @Autowired
    public JobHistoryServiceImp(JobHistoryComponent component) {
        this.component = component;
    }
    /**
     * getJobHistory
     * @param bidUser
     * @return List<JobHistoryDataset>
     */
    @Override
    public List<JobHistoryDataset> getJobHistory(@RequestParam String bidUser) {
        return component.getJobHistory(bidUser);
    }
	@Override
	public List<UserFeedback> getUserFeedback(String username) {
		// TODO Auto-generated method stub
		return component.getUserFeedback(username);
	}
	@Override
	public List<JobHistoryDataset> getUserJobHistory(String username) {
		// TODO Auto-generated method stub
		return component.getUserJobHistory(username);
	}
}
