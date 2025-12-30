package com.malcolm.demo.isc.consumer.webclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class WebClientController {

	private final ProviderWebClient providerWebClient;

	@GetMapping("/api/web-client")
	public Mono<String> getInstance() {
		return providerWebClient.getInstanceInfo();
	}
}
