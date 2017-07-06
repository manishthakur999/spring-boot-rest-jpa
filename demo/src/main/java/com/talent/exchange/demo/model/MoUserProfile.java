package com.talent.exchange.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tex_user_profile")
public class MoUserProfile extends MoBase {

	@Column(name = "photo_url", length = 1024, columnDefinition = "varchar(1024)")
	private String photoUrl;

	@Column(name = "display_lastname")
	private boolean displayLastName = true;

	@Column(name = "facebook_url", length = 1024, columnDefinition = "varchar(1024)")
	private String facebookUrl;

	@Column(name = "twitter_url", length = 1024, columnDefinition = "varchar(1024)")
	private String twitterUrl;

	@Column(name = "instagram_url", length = 1024, columnDefinition = "varchar(1024)")
	private String instagramUrl;

	@Column(name = "imdb_url", length = 1024, columnDefinition = "varchar(1024)")
	private String imdbUrl;

	@Column(name = "wikisite_url", length = 1024, columnDefinition = "varchar(1024)")
	private String wikiSiteUrl;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_profile_user"))
	private MoUser user;

	@Column(name = "facebook_followers")
	private long facebookFollowers;

	@Column(name = "twitter_followers")
	private long twitterFollowers;

	@Column(name = "instagram_followers")
	private long instagramFollowers;
	
	@Column(name = "profile_image", length = 1024, columnDefinition = "varchar(1024)")
	private String profileImage;
	
	@Column(name = "cover_image", length = 1024, columnDefinition = "varchar(1024)")
	private String coverImage;
	
	@Column(name = "number_of_views")
	private long numberOfViews;
	
	@Column(name = "stars")
	private double stars;
	
	@Column(name = "money_earned")
	private double moneyEarned;
	
	@Column(name = "followers")
	private long followers;
	
	@Column(name = "following")
	private long following;
	
	@Column(name = "industry")
	private long industry;
	
	@Column(name = "investments")
	private double investments;
	
	@Column(name = "realtime_trending")
	private double realTimeTrending;
	
	@Column(name = "donation_recieved")
	private double donationRecieved;
	
	@Column(name = "user_endorsement")
	private long userEndorsement;
	

	public long getFacebookFollowers() {
		return facebookFollowers;
	}

	public void setFacebookFollowers(long facebookLikes) {
		this.facebookFollowers = facebookLikes;
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photo_url) {
		this.photoUrl = photo_url;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebook_url) {
		this.facebookUrl = facebook_url;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitter_url) {
		this.twitterUrl = twitter_url;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagram_url) {
		this.instagramUrl = instagram_url;
	}

	public String getImdbUrl() {
		return imdbUrl;
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

	public void setImdbUrl(String imdb_url) {
		this.imdbUrl = imdb_url;
	}

	public String getWikiSiteUrl() {
		return wikiSiteUrl;
	}

	public void setWikiSiteUrl(String wikiSiteUrl) {
		this.wikiSiteUrl = wikiSiteUrl;
	}

	public boolean isDisplayLastName() {
		return displayLastName;
	}

	public void setDisplayLastName(boolean displayLastName) {
		this.displayLastName = displayLastName;
	}

	public MoUser getUser() {
		return user;
	}

	public void setUser(MoUser user) {
		this.user = user;
	}
	
	public long getUserEndorsement() {
		return userEndorsement;
	}

	public void setUserEndorsement(long userEndorsement) {
		this.userEndorsement = userEndorsement;
	}

	@Override
	public String toString() {
		return "MoUserProfile [photoUrl=" + photoUrl + ", displayLastName=" + displayLastName + ", facebookUrl="
				+ facebookUrl + ", twitterUrl=" + twitterUrl + ", instagramUrl=" + instagramUrl + ", imdbUrl=" + imdbUrl
				+ ", wikiSiteUrl=" + wikiSiteUrl + ", user=" + user + ", facebookFollowers=" + facebookFollowers
				+ ", twitterFollowers=" + twitterFollowers + ", instagramFollowers=" + instagramFollowers
				+ ", profileImage=" + profileImage + ", coverImage=" + coverImage + ", numberOfViews=" + numberOfViews
				+ ", stars=" + stars + ", moneyEarned=" + moneyEarned + ", followers=" + followers + ", following="
				+ following + ", industry=" + industry + ", investments=" + investments + ", realTimeTrending="
				+ realTimeTrending + ", donationRecieved=" + donationRecieved + ", userEndorsement=" + userEndorsement
				+ ", getFacebookFollowers()=" + getFacebookFollowers() + ", getTwitterFollowers()="
				+ getTwitterFollowers() + ", getInstagramFollowers()=" + getInstagramFollowers() + ", getPhotoUrl()="
				+ getPhotoUrl() + ", getFacebookUrl()=" + getFacebookUrl() + ", getTwitterUrl()=" + getTwitterUrl()
				+ ", getInstagramUrl()=" + getInstagramUrl() + ", getImdbUrl()=" + getImdbUrl() + ", getProfileImage()="
				+ getProfileImage() + ", getCoverImage()=" + getCoverImage() + ", getNumberOfViews()="
				+ getNumberOfViews() + ", getStars()=" + getStars() + ", getMoneyEarned()=" + getMoneyEarned()
				+ ", getFollowers()=" + getFollowers() + ", getFollowing()=" + getFollowing() + ", getIndustry()="
				+ getIndustry() + ", getInvestments()=" + getInvestments() + ", getRealTimeTrending()="
				+ getRealTimeTrending() + ", getDonationRecieved()=" + getDonationRecieved() + ", getWikiSiteUrl()="
				+ getWikiSiteUrl() + ", isDisplayLastName()=" + isDisplayLastName() + ", getUser()=" + getUser()
				+ ", getUserEndorsement()=" + getUserEndorsement() + ", getId()=" + getId() + ", getVersion()="
				+ getVersion() + ", getCreationDate()=" + getCreationDate() + ", getLastModificationDate()="
				+ getLastModificationDate() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
