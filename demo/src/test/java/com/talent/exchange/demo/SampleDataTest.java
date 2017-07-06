package com.talent.exchange.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SampleDataTest {
	private RestTemplate restTemplate = new RestTemplate();
	  String url = "http://localhost:8080/talentExchange";
	
	public void getArticleByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        
	  
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        
        //ResponseEntity<Void> responseEntity = restTemplate.get
        //ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Article.class, 1);
             
    }

}
