package com.talent.exchange.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({	
		@NamedQuery(name = "artist.by.liveVideo", query = "from MoEventContent event where event.isLiveVideo = true order by event.creationDate desc") ,
		@NamedQuery(name = "getAllArtists", query = "from MoEventContent"),
		@NamedQuery(name = "video.by.artist", query = "from MoEventContent event where event.artist = :artist")
})

@Entity
@Table(name = "tex_event_content")
public class MoEventContent extends MoMediaContent {

	public static final String QUERY_ARTIST_BY_LIVE_VIDEO = "artist.by.liveVideo";
	public static final String QUERY_GET_ALL_ARTISTS = "getAllArtists";
	public static final String QUERY_VIDEO_BY_ARTIST = "video.by.artist";
	
	public final static String ATTR_USER_ARTIST = "artist";

	@Column(name = "video_length")
	private long videoLength;

	@Column(name = "media_id")
	private String mediaId;

	@Column(name = "video_description")
	private String videoDescription;

	@Column(name = "event_title")
	private String eventTitle;

	@Column(name = "event_logLine")
	private String eventLogLine;	

	@Column(name = "isLiveVideo")
	private boolean isLiveVideo;

	@Column(name = "isArchived")
	private boolean isArchived;

	@Column(name = "event_video_path")
	private String eventVideoPath;

	@Column(name = "event_image_path")
	private String eventImagePath;

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

	public void setVideoLength(Long videoLength) {
		this.videoLength = videoLength;
	}

	public boolean isLiveVideo() {
		return isLiveVideo;
	}

	public void setLiveVideo(boolean isLiveVideo) {
		this.isLiveVideo = isLiveVideo;
	}
	
	
	@Override
	public String toString() {
		return "MoEventContent [videoLength=" + videoLength + ", mediaId=" + mediaId + ", videoDescription="
				+ videoDescription + ", eventTitle=" + eventTitle + ", eventLogLine=" + eventLogLine + ", isLiveVideo="
				+ isLiveVideo + ", isArchived=" + isArchived + ", eventVideoPath=" + eventVideoPath
				+ ", eventImagePath=" + eventImagePath + "]";
	}

}
