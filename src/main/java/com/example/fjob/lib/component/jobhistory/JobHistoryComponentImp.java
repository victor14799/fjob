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

    private AccountMapper accountMapper;

    @Autowired
    public JobHistoryComponentImp(JobHistoryMapper mapper, AccountMapper accountMapper) {
        this.mapper = mapper;
        this.accountMapper = accountMapper;
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
        boolean result = mapper.updateFeedback(paramDataset) > 0;
        if (result) {
            if (paramDataset.getStatus().equals("2")) {
                List<UserFeedback> userFeedbackList = this.getUserFeedback(paramDataset.getBidUser());
                double sumFeedback = userFeedbackList.stream().mapToDouble(i -> Double.parseDouble(i.getFeedback())).sum();
                double newFeedback = sumFeedback / userFeedbackList.size();
                int denominator = 2;
                double feedbackDouble = Math.round(newFeedback*denominator);
                String feedback = feedbackDouble/denominator +"";
                accountMapper.updateFeedBack(paramDataset.getBidUser(), feedback);
            }
        }
        return result;
    }

    @Override
    public List<UserFeedback> getUserFeedback(String username) {
        return mapper.selUserFeedback(username);
    }

    @Override
    public List<JobHistoryDataset> getUserJobHistory(String username) {
        return mapper.getUserJobHistory(username);
    }

    @Override
    public AccountDataset getPickUser(String postId) {
        String username = mapper.getPickUser(postId);
        return accountMapper.getAllInfor(username);
    }
}
