package com.talent.exchange.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoDTO {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("video_comments")
	private List<VideoUserActionDTO> comments = new ArrayList<VideoUserActionDTO>();

	@JsonProperty("video_length")
	private long videoLength;

	@JsonProperty("media_id")
	private String mediaId;

	@JsonProperty("video_description")
	private String videoDescription;

	@JsonProperty("event_title")
	private String eventTitle;

	@JsonProperty("event_log_line")
	private String eventLogLine;
	
	@JsonProperty("is_live_video")
	private boolean isLiveVideo;

	@JsonProperty("is_archived")
	private boolean isArchived;

	@JsonProperty("event_video_path")
	private String eventVideoPath;

	@JsonProperty("event_image_path")
	private String eventImagePath;

	@JsonProperty("name")
	private String name;

	/*@JsonProperty("artist")
	protected UserFanDTO artist;*/

	@JsonProperty("published_date")
	private Date publishedDate;

	@JsonProperty("published")
	private boolean published;

	@JsonProperty("original_filename")
	private String originalFileName;

	@JsonProperty("approval_status")
	private String approvalStatus;

	@JsonProperty("file_size")
	private long fileSize;

	@JsonProperty("endorsement")
	private long endorsement;

	@JsonProperty("video_category")
	private String videoCategory;

	@JsonProperty("media_category")
	private String mediaCategory;

	public List<VideoUserActionDTO> getComments() {
		return comments;
	}

	public void setComments(List<VideoUserActionDTO> comments) {
		this.comments = comments;
	}

	public long getVideoLength() {
		return videoLength;
	}

	public void setVideoLength(long videoLength) {
		this.videoLength = videoLength;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getVideoDescription() {
		return videoDescription;
	}

	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventLogLine() {
		return eventLogLine;
	}

	public void setEventLogLine(String eventLogLine) {
		this.eventLogLine = eventLogLine;
	}

	public boolean isLiveVideo() {
		return isLiveVideo;
	}

	public void setLiveVideo(boolean isLiveVideo) {
		this.isLiveVideo = isLiveVideo;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	public String getEventVideoPath() {
		return eventVideoPath;
	}

	public void setEventVideoPath(String eventVideoPath) {
		this.eventVideoPath = eventVideoPath;
	}

	public String getEventImagePath() {
		return eventImagePath;
	}

	public void setEventImagePath(String eventImagePath) {
		this.eventImagePath = eventImagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public UserFanDTO getArtist() {
		return artist;
	}

	public void setArtist(UserFanDTO artist) {
		this.artist = artist;
	}*/

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public long getEndorsement() {
		return endorsement;
	}

	public void setEndorsement(long endorsement) {
		this.endorsement = endorsement;
	}

	public String getVideoCategory() {
		return videoCategory;
	}

	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}

	public String getMediaCategory() {
		return mediaCategory;
	}

	public void setMediaCategory(String mediaCategory) {
		this.mediaCategory = mediaCategory;
	}
}
