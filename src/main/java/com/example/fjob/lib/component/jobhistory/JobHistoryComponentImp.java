package com.example.fjob.lib.component.jobhistory;

import com.example.fjob.lib.dataset.account.AccountDataset;
import com.example.fjob.lib.dataset.jobhistory.JobHistoryDataset;
import com.example.fjob.lib.dataset.jobhistory.JobParamDataset;
import com.example.fjob.lib.dataset.jobhistory.UserFeedback;
import com.example.fjob.lib.mapper.account.AccountMapper;
import com.example.fjob.lib.mapper.jobhistory.JobHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobHistoryComponentImp implements JobHistoryComponent {

	/**
	 * JobHistoryMapper
	 */
	private JobHistoryMapper mapper;

	private AccountMapper accouneMapper;

	@Autowired
	public JobHistoryComponentImp(JobHistoryMapper mapper, AccountMapper accouneMapper) {
		this.mapper = mapper;
		this.accouneMapper = accouneMapper;
	}

	/**
	 * getJobHistory
	 *
	 * @param bidUser
	 * @return List<JobHistoryDataset>
	 */
	@Override
	public List<JobHistoryDataset> getJobHistory(String bidUser) {
		return mapper.getJobHistory(bidUser);
	}

	/**
	 * addJob
	 *
	 * @param paramDataset
	 * @return boolean
	 */
	@Override
	public boolean addJob(JobParamDataset paramDataset) {
		return mapper.addJob(paramDataset) > 0;
	}

	/**
	 * updateFeedback
	 *
	 * @param paramDataset
	 * @return boolean
	 */
	@Override
	public boolean updateFeedback(JobParamDataset paramDataset) {
		return mapper.updateFeedback(paramDataset) > 0;
	}

	@Override
	public List<UserFeedback> getUserFeedback(String username) {
		// TODO Auto-generated method stub
		return mapper.selUserFeedback(username);
	}

	@Override
	public List<JobHistoryDataset> getUserJobHistory(String username) {
		// TODO Auto-generated method stub
		return mapper.getUserJobHistory(username);
	}

	@Override
	public AccountDataset getPickUser(String postId) {
		String username = mapper.getPickUser(postId);
		return accouneMapper.getAllInfor(username);
	}
}
