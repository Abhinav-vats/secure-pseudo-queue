package com.hackerearth.finalApplication.APICallingAPI.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerearth.finalApplication.APICallingAPI.dta.Account;
import com.hackerearth.finalApplication.APICallingAPI.dto.RestCallResponse;

@Service
public class SecurePseudoQueueServiceImpl implements SecurePseudoQueueService {
	
	final ObjectMapper jsonObj =  new ObjectMapper();

	@Override
	public String encodeJSONtoString(final Account account) throws JsonProcessingException {
		System.out.println("Entered: SecurePseudoQueueServiceImpl.encodeJSONtoString");
		final String jsonAccount = jsonObj.writeValueAsString(account);
		 
		System.out.println("Exited: SecurePseudoQueueServiceImpl.encodeJSONtoString");
		return Base64Utils.encodeToString(jsonAccount.getBytes());
		
	}

	@Override
	public String callAPIToGetResponse(final String inputRequest) throws JsonMappingException, JsonProcessingException {
		System.out.println("Entered: SecurePseudoQueueServiceImpl.callAPIToGetResponse");
		String restCallResponse = null;
		
		final HttpEntity<String> entity = new HttpEntity<String>(inputRequest);
		
		final RestTemplate restTemplate = new RestTemplate();
		
		final ResponseEntity<String> response = restTemplate.postForEntity("https://pseudo-queue.herokuapp.com/pseudo-queue/addAccount", entity, String.class	);
		if(null!=response && response.getStatusCode()==HttpStatus.OK) {
			restCallResponse = response.getBody();
		}
		System.out.println("Entered: SecurePseudoQueueServiceImpl.callAPIToGetResponse");
		return restCallResponse;
		
	}

}
