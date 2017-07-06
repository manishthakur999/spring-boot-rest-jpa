package com.talent.exchange.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public class MoMediaContent extends MoBase {

	@Column(name = "name", length = 255)
	private String name;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id"))
	protected MoUser artist;

	@Column(name = "published_date")
	private Date publishedDate;

	@Column(name = "published")
	private boolean published = true;

	@Column(name = "original_file_name")
	private String originalFileName;

	@Column(name = "approval_status", length = 32)
	@Enumerated(EnumType.STRING)
	private MoUserEnum.APPROVAL_STATUS approvalStatus;

	@Column(name = "file_size")
	private long fileSize;

	@Column(name = "endorsement")
	private long endorsement;

	@Column(name = "video_category")
	@Enumerated(EnumType.STRING)
	private MoUserEnum.VIDEO_CATEGORY videoCategory;

	@Column(name = "media_category")
	@Enumerated(EnumType.STRING)
	private MoUserEnum.MEDIA_CATEGORY mediaCategory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MoUser getArtist() {
		return artist;
	}

	public void setArtist(MoUser artist) {
		this.artist = artist;
	}

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

	public MoUserEnum.APPROVAL_STATUS getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(MoUserEnum.APPROVAL_STATUS approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public MoUserEnum.VIDEO_CATEGORY getVideoCategory() {
		return videoCategory;
	}

	public void setVideoCategory(MoUserEnum.VIDEO_CATEGORY videoCategory) {
		this.videoCategory = videoCategory;
	}

	public MoUserEnum.MEDIA_CATEGORY getMediaCategory() {
		return mediaCategory;
	}

	public void setMediaCategory(MoUserEnum.MEDIA_CATEGORY mediaCategory) {
		this.mediaCategory = mediaCategory;
	}

	public long getEndorsement() {
		return endorsement;
	}

	public void setEndorsement(long endorsement) {
		this.endorsement = endorsement;
	}
}
