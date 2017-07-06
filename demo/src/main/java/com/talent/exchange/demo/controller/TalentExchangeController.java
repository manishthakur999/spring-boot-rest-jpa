package com.talent.exchange.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talent.exchange.demo.dto.VideoUserActionDTO;
import com.talent.exchange.demo.dto.UserArtistDTO;
import com.talent.exchange.demo.dto.UserFanDTO;
import com.talent.exchange.demo.service.TalentExchangeDemoService;

@RestController
@RequestMapping(path = "/talentExchange")
public class TalentExchangeController {

	@Autowired
	private TalentExchangeDemoService talentExchangeDemoService;

	@RequestMapping(path = "/sampleData", method = RequestMethod.GET)
	public void sampleData() {
		talentExchangeDemoService.sampleData();
	}

	@RequestMapping(path = "/activeArtists", method = RequestMethod.GET)
	public ResponseEntity<List<UserArtistDTO>> getActiveArtists() {
		List<UserArtistDTO> activeArtists = talentExchangeDemoService.getActiveEvents();
		return new ResponseEntity(activeArtists, HttpStatus.OK);
	}

	@RequestMapping(path = "/allArtists", method = RequestMethod.GET)
	public ResponseEntity<List<UserArtistDTO>> getAllArtists() {
		List<UserArtistDTO> allArtists = talentExchangeDemoService.getAllEvents();
		return new ResponseEntity(allArtists, HttpStatus.OK);
	}

	@RequestMapping(path = "/allFans", method = RequestMethod.GET)
	public ResponseEntity<List<UserArtistDTO>> getAllFans() {
		List<UserFanDTO> getAllFanDTO = talentExchangeDemoService.getAllFans();
		return new ResponseEntity(getAllFanDTO, HttpStatus.OK);
	}

	
	@RequestMapping(path = "/fan", method = RequestMethod.GET)
	public ResponseEntity<UserArtistDTO> getFanBioSocial(@RequestParam String fanId) {
		UserFanDTO fanBioSocial = talentExchangeDemoService.getFanBioSocial(fanId);
		return new ResponseEntity(fanBioSocial, HttpStatus.OK);
	}
	
/*	@RequestMapping(path = "/fan", method = RequestMethod.GET)
	public ResponseEntity<UserArtistDTO> getFanBioSocial(@RequestHeader(value="fanId") String fanId) {
		UserFanDTO fanBioSocial = talentExchangeDemoService.getFanBioSocial(fanId);
		return new ResponseEntity(fanBioSocial, HttpStatus.OK);
	}*/
	
	
	@RequestMapping(path = "/fansBasedOnCommentsOfVideo", method = RequestMethod.GET)
	public ResponseEntity<UserArtistDTO> getFansBasedOnCommentsOfVideo(@RequestParam String videoId) {
		 Set<UserFanDTO> fansBasedOnCommentsOfVideo = talentExchangeDemoService.getFansBasedOnCommentsOfVideo(videoId);
		return new ResponseEntity(fansBasedOnCommentsOfVideo, HttpStatus.OK);
	}
	
	
	/*@RequestMapping(path = "/fansCommentsOfVideo", method = RequestMethod.GET)
	public ResponseEntity<AllVideoInfoDTO> getAllOfVideo(@RequestParam String videoId) {
		 Set<UserFanDTO> fansBasedOnCommentsOfVideo = talentExchangeDemoService.getFansBasedOnCommentsOfVideo(videoId);
		return new ResponseEntity(fansBasedOnCommentsOfVideo, HttpStatus.OK);
	}*/
	
	
}
