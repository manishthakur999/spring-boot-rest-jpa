package com.talent.exchange.demo.service;

import java.util.List;
import java.util.Set;

import com.talent.exchange.demo.dto.VideoUserActionDTO;
import com.talent.exchange.demo.dto.UserArtistDTO;
import com.talent.exchange.demo.dto.UserFanDTO;
import com.talent.exchange.demo.model.MoVideoUserAction;

public interface TalentExchangeDemoService {
	void sampleData();
	List<UserArtistDTO> getActiveEvents();
	List<UserArtistDTO> getAllEvents();
	List<UserFanDTO> getAllFans();
	UserFanDTO getFanBioSocial(String id);
	Set<UserFanDTO> getFansBasedOnCommentsOfVideo(String videoId);
	List<VideoUserActionDTO> getAllCommentsOfVideo(String videoId);
	List<MoVideoUserAction> getAllVideoOfArtist(String userArtistId);
}
