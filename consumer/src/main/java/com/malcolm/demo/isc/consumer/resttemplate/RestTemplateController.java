package com.malcolm.demo.isc.consumer.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rest-template")
@RequiredArgsConstructor
public class RestTemplateController {

	@Autowired
	private final RestTemplateClient restTemplateClient;

	@GetMapping("/instance")
	public String getInstance() {
		return restTemplateClient.getInstanceInfo();
	}

}
