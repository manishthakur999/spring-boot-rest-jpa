package com.talent.exchange.demo.utility;

import java.util.ArrayList;
import java.util.List;

import com.talent.exchange.demo.dto.UserArtistDTO;
import com.talent.exchange.demo.dto.UserFanDTO;
import com.talent.exchange.demo.model.MoEventContent;
import com.talent.exchange.demo.model.MoUser;

public class UserModelToDTOConvertor {

	
	public List<UserArtistDTO> getUserDTO(List<MoEventContent> activeArtists) {
		List<UserArtistDTO> userDtoList = new ArrayList<>();
		if (activeArtists != null && activeArtists.size() > 0) {
			for (MoEventContent event : activeArtists) {
				userDtoList.add(getUserDTO(event));
			}
		}
		return userDtoList;
	}
	
	public List<UserFanDTO> getUserDTOfromMoUser(List<MoUser> allFans) {
		List<UserFanDTO> userFanDtoList = new ArrayList<>();
		if (allFans != null && allFans.size() > 0) {
			for (MoUser user : allFans) {
				userFanDtoList.add(getUserDTOfromMoUser(user));
			}
		}
		return userFanDtoList;
	}
	
	/*public List<AllVideoInfoDTO> getUserDTOfromVideoAction(List<MoUser> allFans) {
		List<UserFanDTO> userFanDtoList = new ArrayList<>();
		if (allFans != null && allFans.size() > 0) {
			for (MoUser user : allFans) {
				userFanDtoList.add(getUserDTOfromMoUser(user));
			}
		}
		return userFanDtoList;
	}*/

	private UserFanDTO getUserDTOfromMoUser(MoUser user) {
		UserFanDTO userFanDto = new UserFanDTO();
		
		userFanDto.setAccountStatus(user.getAccountStatus().name());
		userFanDto.setAddressLine1(user.getAddress().getAddressLine1());
		userFanDto.setAddressLine2(user.getAddress().getAddressLine2());
		userFanDto.setAddressType(user.getAddress().getAddressType().toString());
		userFanDto.setArtist(user.isArtist());
		userFanDto.setCity(user.getAddress().getCity());
		userFanDto.setCountry(user.getAddress().getCountry());
		userFanDto.setCoverImage(user.getUserProfile().getCoverImage());
		userFanDto.setDeleted(user.isDeleted());
		userFanDto.setDialcode(user.getDialcode());
		userFanDto.setDonationRecieved(user.getUserProfile().getDonationRecieved());
		userFanDto.setEmail(user.getEmail());
		userFanDto.setEmailVerified(user.isEmailVerified());
		userFanDto.setFacebookFollowers(user.getUserProfile().getFacebookFollowers());
		userFanDto.setFacebookUrl(user.getUserProfile().getFacebookUrl());
		userFanDto.setFan(user.isFan());
		userFanDto.setFirstName(user.getFirstName());
		userFanDto.setFollowers(user.getUserProfile().getFollowers());
		userFanDto.setFollowing(user.getUserProfile().getFollowing());
		userFanDto.setGender(user.getGender().name());
		userFanDto.setImdbUrl(user.getUserProfile().getImdbUrl());		
		userFanDto.setIndustry(user.getUserProfile().getIndustry());
		userFanDto.setInstagramFollowers(user.getUserProfile().getInstagramFollowers());
		userFanDto.setInstagramUrl(user.getUserProfile().getInstagramUrl());
		userFanDto.setInvestments(user.getUserProfile().getInvestments());
		userFanDto.setInvestor(user.isInvestor());
		userFanDto.setLastName(user.getLastName());
		userFanDto.setLocale(user.getLocale());
		userFanDto.setMailCode(user.getAddress().getMailCode());
		userFanDto.setMobile(user.getMobile());
		userFanDto.setMoneyEarned(user.getUserProfile().getMoneyEarned());
		userFanDto.setNumberOfViews(user.getUserProfile().getNumberOfViews());
		userFanDto.setPhone(user.getPhone());
		userFanDto.setPhotoUrl(user.getUserProfile().getPhotoUrl());
		userFanDto.setProfileImage(user.getUserProfile().getProfileImage());
		userFanDto.setRealTimeTrending(user.getUserProfile().getRealTimeTrending());
		userFanDto.setStars(user.getUserProfile().getStars());
		userFanDto.setState(user.getAddress().getState());
		userFanDto.setUserEndorsement(user.getUserProfile().getUserEndorsement());
		userFanDto.setUserName(user.getUserName());
		userFanDto.setUserType(user.getUserType().toString());
		userFanDto.setWikiSiteUrl(user.getUserProfile().getWikiSiteUrl());
		
		
		
		
		
		
		
		
		
		/*@JsonProperty("user_name")
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
		private String country;*/
		return userFanDto;
	}
	
	
	private UserArtistDTO getUserDTO(MoEventContent event) {
		UserArtistDTO userDto = new UserArtistDTO();
		userDto.setCity(event.getArtist().getAddress().getCity());
		userDto.setCoverImage(event.getArtist().getUserProfile().getCoverImage());
		userDto.setDonationsReceived(event.getArtist().getUserProfile().getDonationRecieved());
		userDto.setEventEndorsement(event.getEndorsement());
		userDto.setEventImage(event.getEventImagePath());
		userDto.setEventTitle(event.getEventTitle());
		userDto.setEventVideo(event.getEventVideoPath());
		userDto.setFirstName(event.getArtist().getFirstName());
		userDto.setFollowing(event.getArtist().getUserProfile().getFollowing());
		userDto.setFollwers(event.getArtist().getUserProfile().getFollowers());
		userDto.setId(event.getArtist().getId());
		userDto.setIndustry(event.getArtist().getUserProfile().getIndustry());
		userDto.setInvestment(event.getArtist().getUserProfile().getInvestments());
		userDto.setLastName(event.getArtist().getLastName());
		userDto.setMoneyEarned(event.getArtist().getUserProfile().getMoneyEarned());
		userDto.setNumberOfViews(event.getArtist().getUserProfile().getNumberOfViews());
		userDto.setProfileImg(event.getArtist().getUserProfile().getProfileImage());
		userDto.setRealtimetrending(event.getArtist().getUserProfile().getRealTimeTrending());
		userDto.setStars(event.getArtist().getUserProfile().getStars());
		userDto.setUserType(event.getArtist().getUserType().name());
		return userDto;
	}
}
