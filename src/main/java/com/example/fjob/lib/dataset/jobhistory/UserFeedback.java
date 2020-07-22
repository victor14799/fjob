package com.example.fjob.lib.dataset.jobhistory;

import java.util.Date;

public class UserFeedback {
	private String feedback;
	private String comment;
	private Date feedbackDate;
	private String title;
	private String fullname;

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
