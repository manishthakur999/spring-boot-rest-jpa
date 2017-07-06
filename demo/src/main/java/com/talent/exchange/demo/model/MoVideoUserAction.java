package com.talent.exchange.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
		@NamedQuery(name = "fans.based.on.comments.of.video", query = "Select userFan from MoVideoUserAction userAction where userAction.video = :video"),
		@NamedQuery(name = "get.all.based.on.video", query = "from MoVideoUserAction userAction where userAction.video = :video") })

@Entity
@Table(name = "tex_user_action")
public class MoVideoUserAction extends MoBase {

	public static final String QUERY_FANS_BASED_ON_COMMENTS_OF_VIDEO = "fans.based.on.comments.of.video";
	public static final String QUERY_GET_ALL_BASED_ON_VIDEO = "get.all.based.on.video";

	public final static String ATTR_VIDEO = "video";
	public final static String ATTR_USER_FAN = "userFan";
	public final static String ATTR_USER_ARTIST = "userArtist";

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private MoEventContent video;

	@Column(name = "comment")
	private String comment;

	@Column(name = "endorse")
	private boolean endorse;

	@Column(name = "rating")
	private int rating; // ranging

	@Column(name = "is_Following")
	private boolean isFollowing;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private MoUser userFan; // user commenting on video

	public MoEventContent getVideo() {
		return video;
	}

	public void setVideo(MoEventContent video) {
		this.video = video;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isEndorse() {
		return endorse;
	}

	public void setEndorse(boolean endorse) {
		this.endorse = endorse;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isFollowing() {
		return isFollowing;
	}

	public void setFollowing(boolean isFollowing) {
		this.isFollowing = isFollowing;
	}

	public MoUser getUserFan() {
		return userFan;
	}

	public void setUserFan(MoUser userFan) {
		this.userFan = userFan;
	}

	@Override
	public String toString() {
		return "MoVideoUserAction [video=" + video + ", comment=" + comment + ", endorse=" + endorse + ", rating="
				+ rating + ", isFollowing=" + isFollowing + ", userFan=" + userFan + "]";
	}
}
