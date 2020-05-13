package com.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.services.ChatbotUtilService;

@RestController
@RequestMapping("/bot")
public class BotRequestController {

	@Autowired
	ChatbotUtilService chatbot;
	
	@GetMapping(path = "/send/{message}")
	public String sendReuest(@PathVariable String message) {
		return chatbot.getBotResponse(message);
	}

}
