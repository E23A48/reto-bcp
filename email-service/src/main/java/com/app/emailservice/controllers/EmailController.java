package com.app.emailservice.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.emailservice.models.entity.Email;
import com.app.emailservice.models.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/notifications")
@Slf4j
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping(value="/textemail",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> sendEmailto(@RequestBody Email emailTemplate) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		emailService.sendTextEmail(emailTemplate);
        map.put("message", "Email enviado");

		return ResponseEntity.ok(map);
		
	}
	
}

