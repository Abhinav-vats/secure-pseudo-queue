package com.hackerearth.finalApplication.APICallingAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackerearth.finalApplication.APICallingAPI.dta.Account;
import com.hackerearth.finalApplication.APICallingAPI.services.SecurePseudoQueueService;

@RestController
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SecurePseudoQueueController {
	
	
	@Autowired
	private SecurePseudoQueueService securePseudoQueueService;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return "Welcome to the PseudoQueue Project";
	}
	
	@PostMapping("/addAccount")
	public ResponseEntity addAccount(@RequestBody final Account account) {
		System.out.println("Entered: SecurePseudoQueueController.addAccount");
		String restCallResponse = null;
		String inputBody;
		try {
			inputBody = securePseudoQueueService.encodeJSONtoString(account);
			restCallResponse = securePseudoQueueService.callAPIToGetResponse(inputBody);
		} catch (JsonProcessingException e) {
			System.out.println(e.getLocalizedMessage());
			restCallResponse = "{\"status\": \"BAD REQUEST\",\"statusCode\": 400,\"message\": \"Not Added Successfully\"}";
		}
		
		System.out.println("Exited: SecurePseudoQueueController.addAccount");
		return new ResponseEntity(restCallResponse, HttpStatus.OK);
				
		
	}

}
