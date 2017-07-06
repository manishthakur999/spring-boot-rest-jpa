package com.talent.exchange.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoUserActionDTO {

	@JsonProperty("id")
	private String id;

	@JsonProperty("creation_date")
	private String creationDate;

	@JsonProperty("comment")
	private String comment;

	@JsonProperty("userFan")
	private UserFanDTO userFan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UserFanDTO getUserFan() {
		return userFan;
	}

	public void setUserFan(UserFanDTO userFan) {
		this.userFan = userFan;
	}

}
