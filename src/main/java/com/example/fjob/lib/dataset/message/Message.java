package com.example.fjob.lib.dataset.message;

import java.util.Date;

public class Message {

	private String id;
	private String username;
	private String title;
	private String body;
	private String payload;
	private Date ins_date;
	private String seen_flg;
	private String img;
	private String addUsername;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAddUsername() {
		return addUsername;
	}

	public void setAddUsername(String addUsername) {
		this.addUsername = addUsername;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getIns_date() {
		return ins_date;
	}

	public void setIns_date(Date ins_date) {
		this.ins_date = ins_date;
	}

	public String getSeen_flg() {
		return seen_flg;
	}

	public void setSeen_flg(String seen_flg) {
		this.seen_flg = seen_flg;
	}

}
