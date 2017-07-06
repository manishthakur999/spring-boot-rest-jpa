package com.talent.exchange.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserArtistDTO {

	@JsonProperty("user_id")
	private String id;

	@JsonProperty("user_type")
	private String userType;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("profile_img")
	private String profileImg;

	@JsonProperty("cover_image")
	private String coverImage;

	@JsonProperty("city")
	private String city;

	@JsonProperty("number_of_view")
	private long numberOfViews;

	@JsonProperty("stars")
	private double stars;

	@JsonProperty("money_earned")
	private double moneyEarned;

	@JsonProperty("followers")
	private long follwers;

	@JsonProperty("following")
	private long following;

	@JsonProperty("event_title")
	private String eventTitle;

	@JsonProperty("event_image")
	private String eventImage;

	@JsonProperty("event_video")
	private String eventVideo;

	@JsonProperty("event_endorsement")
	private long eventEndorsement;

	@JsonProperty("industry")
	private long industry;

	@JsonProperty("investments")
	private double investment;

	@JsonProperty("realtime_trending")
	private double realtimetrending;

	@JsonProperty("donations_received")
	private double donationsReceived;
	
	@JsonProperty("artist_videos")
	private List<VideoDTO> videos = new ArrayList<VideoDTO>();

	public List<VideoDTO> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoDTO> videos) {
		this.videos = videos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getNumberOfViews() {
		return numberOfViews;
	}

	public void setNumberOfViews(long numberOfViews) {
		this.numberOfViews = numberOfViews;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public double getMoneyEarned() {
		return moneyEarned;
	}

	public void setMoneyEarned(double moneyEarned) {
		this.moneyEarned = moneyEarned;
	}

	public long getFollwers() {
		return follwers;
	}

	public void setFollwers(long follwers) {
		this.follwers = follwers;
	}

	public long getFollowing() {
		return following;
	}

	public void setFollowing(long following) {
		this.following = following;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventImage() {
		return eventImage;
	}

	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}

	public String getEventVideo() {
		return eventVideo;
	}

	public void setEventVideo(String eventVideo) {
		this.eventVideo = eventVideo;
	}

	public long getEventEndorsement() {
		return eventEndorsement;
	}

	public void setEventEndorsement(long eventEndorsement) {
		this.eventEndorsement = eventEndorsement;
	}

	public long getIndustry() {
		return industry;
	}

	public void setIndustry(long industry) {
		this.industry = industry;
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}

	public double getRealtimetrending() {
		return realtimetrending;
	}

	public void setRealtimetrending(double realtimetrending) {
		this.realtimetrending = realtimetrending;
	}

	public double getDonationsReceived() {
		return donationsReceived;
	}

	public void setDonationsReceived(double donationsReceived) {
		this.donationsReceived = donationsReceived;
	}
}
