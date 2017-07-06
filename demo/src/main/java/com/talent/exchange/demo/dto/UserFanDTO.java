package com.talent.exchange.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserFanDTO {

	@JsonProperty("user_name")
	private String userName;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("email")
	private String email;

	@JsonProperty("mobile")
	private String mobile;

	@JsonProperty("locale")
	private String locale;

	@JsonProperty("is_email_verified")
	private boolean isEmailVerified;

	@JsonProperty("is_deleted")
	private boolean isDeleted;

	@JsonProperty("is_fan")
	private boolean isFan; // default true;

	@JsonProperty("is_artist")
	private boolean isArtist;

	@JsonProperty("is_talent")
	private boolean isTalent;

	@JsonProperty("is_investor")
	private boolean isInvestor; // for time being true

	@JsonProperty("user_type")
	private String userType;

	@JsonProperty("account_status")
	private String accountStatus;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("dial_code")
	private String dialcode;

	@JsonProperty("photo_url")
	private String photoUrl;

	@JsonProperty("facebook_url")
	private String facebookUrl;

	@JsonProperty("twitter_url")
	private String twitterUrl;

	@JsonProperty("instagram_url")
	private String instagramUrl;

	@JsonProperty("imdb_url")
	private String imdbUrl;

	@JsonProperty("wikiSite_url")
	private String wikiSiteUrl;

	@JsonProperty("facebook_followers")
	private long facebookFollowers;

	@JsonProperty("twitter_followers")
	private long twitterFollowers;

	@JsonProperty("instagram_followers")
	private long instagramFollowers;

	@JsonProperty("profile_image")
	private String profileImage;

	@JsonProperty("cover_image")
	private String coverImage;

	@JsonProperty("number_of_views")
	private long numberOfViews;

	@JsonProperty("stars")
	private double stars;

	@JsonProperty("money_earned")
	private double moneyEarned;

	@JsonProperty("followers")
	private long followers;

	@JsonProperty("following")
	private long following;

	@JsonProperty("industry")
	private long industry;

	@JsonProperty("investments")
	private double investments;

	@JsonProperty("real_time_trending")
	private double realTimeTrending;

	@JsonProperty("donation_recieved")
	private double donationRecieved;

	@JsonProperty("user_endorsement")
	private long userEndorsement;

	@JsonProperty("address_type")
	private String addressType;

	@JsonProperty("address_line1")
	private String addressLine1;

	@JsonProperty("address_line2")
	private String addressLine2;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("mail_code")
	private String mailCode;

	@JsonProperty("country")
	private String country;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isFan() {
		return isFan;
	}

	public void setFan(boolean isFan) {
		this.isFan = isFan;
	}

	public boolean isArtist() {
		return isArtist;
	}

	public void setArtist(boolean isArtist) {
		this.isArtist = isArtist;
	}

	public boolean isTalent() {
		return isTalent;
	}

	public void setTalent(boolean isTalent) {
		this.isTalent = isTalent;
	}

	public boolean isInvestor() {
		return isInvestor;
	}

	public void setInvestor(boolean isInvestor) {
		this.isInvestor = isInvestor;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDialcode() {
		return dialcode;
	}

	public void setDialcode(String dialcode) {
		this.dialcode = dialcode;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public String getImdbUrl() {
		return imdbUrl;
	}

	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	public String getWikiSiteUrl() {
		return wikiSiteUrl;
	}

	public void setWikiSiteUrl(String wikiSiteUrl) {
		this.wikiSiteUrl = wikiSiteUrl;
	}

	public long getFacebookFollowers() {
		return facebookFollowers;
	}

	public void setFacebookFollowers(long facebookFollowers) {
		this.facebookFollowers = facebookFollowers;
	}

	public long getTwitterFollowers() {
		return twitterFollowers;
	}

	public void setTwitterFollowers(long twitterFollowers) {
		this.twitterFollowers = twitterFollowers;
	}

	public long getInstagramFollowers() {
		return instagramFollowers;
	}

	public void setInstagramFollowers(long instagramFollowers) {
		this.instagramFollowers = instagramFollowers;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
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

	public long getFollowers() {
		return followers;
	}

	public void setFollowers(long followers) {
		this.followers = followers;
	}

	public long getFollowing() {
		return following;
	}

	public void setFollowing(long following) {
		this.following = following;
	}

	public long getIndustry() {
		return industry;
	}

	public void setIndustry(long industry) {
		this.industry = industry;
	}

	public double getInvestments() {
		return investments;
	}

	public void setInvestments(double investments) {
		this.investments = investments;
	}

	public double getRealTimeTrending() {
		return realTimeTrending;
	}

	public void setRealTimeTrending(double realTimeTrending) {
		this.realTimeTrending = realTimeTrending;
	}

	public double getDonationRecieved() {
		return donationRecieved;
	}

	public void setDonationRecieved(double donationRecieved) {
		this.donationRecieved = donationRecieved;
	}

	public long getUserEndorsement() {
		return userEndorsement;
	}

	public void setUserEndorsement(long userEndorsement) {
		this.userEndorsement = userEndorsement;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMailCode() {
		return mailCode;
	}

	public void setMailCode(String mailCode) {
		this.mailCode = mailCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
