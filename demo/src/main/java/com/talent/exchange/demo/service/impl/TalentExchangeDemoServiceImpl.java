package com.talent.exchange.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;
import com.talent.exchange.demo.dao.TalentExchangeDemoDao;
import com.talent.exchange.demo.dto.UserArtistDTO;
import com.talent.exchange.demo.dto.UserFanDTO;
import com.talent.exchange.demo.dto.VideoDTO;
import com.talent.exchange.demo.dto.VideoUserActionDTO;
import com.talent.exchange.demo.model.MoEventContent;
import com.talent.exchange.demo.model.MoUser;
import com.talent.exchange.demo.model.MoVideoUserAction;
import com.talent.exchange.demo.service.TalentExchangeDemoService;
import com.talent.exchange.demo.utility.UserModelToDTOConvertor;

@Service("talentExchangeDemoService")
public class TalentExchangeDemoServiceImpl implements TalentExchangeDemoService {

	@Autowired
	private TalentExchangeDemoDao talentExchangeDemoDao;

	@Override
	public void sampleData() {
		talentExchangeDemoDao.sampleData();
	}
	
	UserModelToDTOConvertor convertor;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserArtistDTO> getActiveEvents() {

		HashMap<String, Object> activeArtistsMap = new HashMap<>();

		/*List<UserArtistDTO> artistsList = new ArrayList<>();
		List<MoUser> userArtistList = null;
		UserArtistDTO userArtistDto = null;*/
		convertor = new UserModelToDTOConvertor();

		List<MoEventContent> getActiveEvents = talentExchangeDemoDao
				.findByNamedQuery(MoEventContent.QUERY_ARTIST_BY_LIVE_VIDEO, activeArtistsMap);

		List<UserArtistDTO> getActiveArtists = getUserDTO(getActiveEvents);
		
		return getActiveArtists;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserArtistDTO> getAllEvents() {
		HashMap<String, Object> activeArtistsMap = new HashMap<>();
		List<MoEventContent> getActiveEvents = talentExchangeDemoDao
				.findByNamedQuery(MoEventContent.QUERY_GET_ALL_ARTISTS, activeArtistsMap);
		convertor = new UserModelToDTOConvertor();
		List<UserArtistDTO> getActiveArtists = convertor.getUserDTO(getActiveEvents);
		return getActiveArtists;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserFanDTO> getAllFans() {
		HashMap<String, Object> allFansMap = new HashMap<>();
		List<MoUser> getAllFans = talentExchangeDemoDao.findByNamedQuery(MoUser.QUERY_FAN_BIO, allFansMap);
		convertor = new UserModelToDTOConvertor();
		List<UserFanDTO> getAllFanDTO = convertor.getUserDTOfromMoUser(getAllFans);
		return getAllFanDTO;		
	}

	@Override
	@Transactional
	public UserFanDTO getFanBioSocial(String id) {		
		MoUser fanBioSocial = talentExchangeDemoDao.findById(MoUser.class, id);
		convertor = new UserModelToDTOConvertor();
		List<MoUser> fanUserList = new ArrayList<>();
		fanUserList.add(fanBioSocial);
		List<UserFanDTO> userDTOfromMoUser = convertor.getUserDTOfromMoUser(fanUserList);
		return userDTOfromMoUser.get(0);
	}

	@Override
	@Transactional
	public Set<UserFanDTO> getFansBasedOnCommentsOfVideo(String videoId) {
		MoEventContent video = getEventContentById(videoId);

		List<MoUser> videoUserActionList = talentExchangeDemoDao.findByNamedQuery(
				MoVideoUserAction.QUERY_FANS_BASED_ON_COMMENTS_OF_VIDEO,
				new ImmutableMap.Builder<String, Object>().put(MoVideoUserAction.ATTR_VIDEO, video).build());
		
		convertor = new UserModelToDTOConvertor();

		List<UserFanDTO> userDTOfromMoUser = convertor.getUserDTOfromMoUser(videoUserActionList);
		Set<UserFanDTO> userFanSet = new HashSet<>(userDTOfromMoUser);
		return userFanSet;
	}

	

	@Override
	@Transactional
	public List<VideoUserActionDTO> getAllCommentsOfVideo(String videoId) {
		VideoUserActionDTO commentDTO = null;
		List<MoUser> userFanList = null;
		
		List<VideoUserActionDTO> videoCommentList = new ArrayList<>();
		
		MoEventContent video = getEventContentById(videoId);
		convertor = new UserModelToDTOConvertor();

		List<MoVideoUserAction> videoList = talentExchangeDemoDao.findByNamedQuery(
				MoVideoUserAction.QUERY_FANS_BASED_ON_COMMENTS_OF_VIDEO,
				new ImmutableMap.Builder<String, Object>().put(MoVideoUserAction.ATTR_VIDEO, video).build());
		
		for(MoVideoUserAction comment : videoList){
			commentDTO = new VideoUserActionDTO();
			commentDTO.setComment(comment.getComment());
			commentDTO.setCreationDate(comment.getCreationDate().toString());
			
			userFanList = new ArrayList<>();
			userFanList.add(comment.getUserFan());
			List<UserFanDTO> userDTOfromMoUser = convertor.getUserDTOfromMoUser(userFanList);
						
			commentDTO.setUserFan(userDTOfromMoUser.get(0));
			commentDTO.setId(comment.getId());
			videoCommentList.add(commentDTO);
		}
		return videoCommentList;
	}

	@Override
	@Transactional
	public List<MoVideoUserAction> getAllVideoOfArtist(String userArtistId) {
		MoUser artist = getMoUserId(userArtistId);

		List<MoVideoUserAction> videoList = talentExchangeDemoDao.findByNamedQuery(
				MoVideoUserAction.QUERY_FANS_BASED_ON_COMMENTS_OF_VIDEO,
				new ImmutableMap.Builder<String, Object>().put(MoVideoUserAction.ATTR_USER_ARTIST, artist).build());

		return videoList;
	}
	
	
	public List<VideoDTO> getVideoList(String userArtistId) {
		MoUser artist = getMoUserId(userArtistId);

		List<VideoDTO> videoDtoList = new ArrayList<>();
		List<MoUser> userFanList = null;
		VideoDTO vDto = null;
		convertor = new UserModelToDTOConvertor();

		List<MoEventContent> videoList = talentExchangeDemoDao.findByNamedQuery(MoEventContent.QUERY_VIDEO_BY_ARTIST,
				new ImmutableMap.Builder<String, Object>().put(MoEventContent.ATTR_USER_ARTIST, artist).build());

		for (MoEventContent video : videoList) {
			vDto = new VideoDTO();
			vDto.setApprovalStatus(video.getApprovalStatus().name());
			vDto.setArchived(video.isArchived());

			userFanList = new ArrayList<>();
			userFanList.add(video.getArtist());

			/*List<UserFanDTO> userDTOfromMoUser = convertor.getUserDTOfromMoUser(userFanList);

			vDto.setArtist(userDTOfromMoUser.get(0));*/

			List<VideoUserActionDTO> allCommentsOfVideo = getAllCommentsOfVideo(video.getId());
			vDto.setComments(allCommentsOfVideo);

			vDto.setEndorsement(video.getEndorsement());
			vDto.setEventImagePath(video.getEventImagePath());
			vDto.setEventLogLine(video.getEventLogLine());
			vDto.setEventTitle(video.getEventTitle());
			vDto.setEventVideoPath(video.getEventVideoPath());
			vDto.setFileSize(video.getFileSize());
			vDto.setLiveVideo(video.isLiveVideo());
			vDto.setMediaCategory(video.getMediaCategory().name());
			vDto.setMediaId(video.getMediaId());
			vDto.setName(video.getName());
			vDto.setOriginalFileName(video.getOriginalFileName());
			vDto.setPublished(video.isPublished());
			vDto.setPublishedDate(video.getPublishedDate());
			vDto.setVideoCategory(video.getVideoCategory().name());
			vDto.setVideoDescription(video.getVideoDescription());
			vDto.setVideoLength(video.getVideoLength());
			videoDtoList.add(vDto);
		}
		return videoDtoList;
	}
	
	
	private List<MoUser> getListFan(List<MoVideoUserAction> videoCommentList){
		List<MoUser> getFanList = new ArrayList<>();
		for(MoVideoUserAction video : videoCommentList){
			getFanList.add(video.getUserFan());
		}
		return getFanList;
	}
	
	
	private MoEventContent getEventContentById(String eventContentId) {
		MoEventContent video = talentExchangeDemoDao.findById(MoEventContent.class, eventContentId);		
		return video;
	}
	
	
	private MoUser getMoUserId(String userId) {
		MoUser user = talentExchangeDemoDao.findById(MoUser.class, userId);		
		return user;
	}
	
	
	public List<UserArtistDTO> getUserDTO(List<MoEventContent> activeArtists) {
		List<UserArtistDTO> userDtoList = new ArrayList<>();
		if (activeArtists != null && activeArtists.size() > 0) {
			for (MoEventContent event : activeArtists) {
				userDtoList.add(getUserDTO(event));
			}
		}
		return userDtoList;
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
		List<VideoDTO> videoList = getVideoList(event.getArtist().getId());
		userDto.setVideos(videoList);
		return userDto;
	}

}
