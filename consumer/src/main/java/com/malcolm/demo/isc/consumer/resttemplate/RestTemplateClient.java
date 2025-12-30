package com.malcolm.demo.isc.consumer.resttemplate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Remember Spring requires the class to have only one constructor to autowire
public class RestTemplateClient {

	private static final String PROVIDER_URL = "http://localhost:8081";
	private final RestTemplate restTemplate;

	public String getInstanceInfo() {
		return restTemplate.getForObject(PROVIDER_URL + "/instance-info", String.class);
	}
}
