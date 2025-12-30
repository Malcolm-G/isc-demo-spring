package com.malcolm.demo.isc.consumer.httpinterface;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterfaceConfig {

	@Bean
	ProviderHttpInterface webClientHttpInterface() {
		WebClient webClient = WebClient.create("http://localhost:8081/");
		WebClientAdapter adapter = WebClientAdapter.create(webClient);
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
		ProviderHttpInterface service = factory.createClient(ProviderHttpInterface.class);
		return service;
	}
	
	@Bean
	ProviderHttpInterface restClientHttpInterface() {
		RestClient  restClient = RestClient.create("http://localhost:8081/");
		RestClientAdapter adapter = RestClientAdapter.create(restClient);
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
		ProviderHttpInterface service = factory.createClient(ProviderHttpInterface.class);
		return service;
	}
}
