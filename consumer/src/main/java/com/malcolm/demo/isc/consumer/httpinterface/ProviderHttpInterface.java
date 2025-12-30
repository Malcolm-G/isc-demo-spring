package com.malcolm.demo.isc.consumer.httpinterface;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import reactor.core.publisher.Mono;

@HttpExchange
public interface ProviderHttpInterface {

	@GetExchange("/instance-info")
	Mono<String> getInstanceInfoAsMono();

	@GetExchange("/instance-info")
	String getInstanceInfo();
}
