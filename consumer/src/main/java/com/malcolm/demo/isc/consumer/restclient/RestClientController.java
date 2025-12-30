package com.malcolm.demo.isc.consumer.restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rest-client")
@RequiredArgsConstructor
public class RestClientController {

	private final ProviderRestClient providerRestClient;

	@GetMapping
	public String getInstance() {
		return providerRestClient.getInstanceInfo();
	}

}
