package com.hackerearth.finalApplication.APICallingAPI.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hackerearth.finalApplication.APICallingAPI.dta.Account;

public interface SecurePseudoQueueService {
	
	public String encodeJSONtoString(final Account account) throws JsonProcessingException;
	
	public String callAPIToGetResponse(final String inputRequest) throws JsonMappingException, JsonProcessingException;

}
