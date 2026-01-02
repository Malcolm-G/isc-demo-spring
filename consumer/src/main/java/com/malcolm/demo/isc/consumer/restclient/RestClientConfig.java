package com.malcolm.demo.isc.consumer.restclient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

	// Unlike RestTemplate we need a LoadBalanced Builder
	@Bean
	@LoadBalanced
	RestClient.Builder loadBalancedRestClientBuilder() {
		return RestClient.builder();
	}

	@Bean
	RestClient restClient(RestClient.Builder builder) {
		return builder.baseUrl("http://provider").build();
	}

}
