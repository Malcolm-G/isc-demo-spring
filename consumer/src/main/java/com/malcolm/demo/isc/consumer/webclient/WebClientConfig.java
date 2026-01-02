package com.malcolm.demo.isc.consumer.webclient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	// Unlike RestTemplate we need a LoadBalanced Builder
	@Bean
	@LoadBalanced
	WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}

	@Bean
	WebClient webClient(WebClient.Builder builder) {
		/*
		 * Use the code commented to change the resolver. WebClient uses Netty's
		 * resolver which has issues with OS hostnames like .mshome.net This will use
		 * JVM's resolver which isn't aync like Netty's but it works. And although it
		 * may block the eventloop slightly it still is unblocking for the main request
		 * 
		 * HttpClient httpClient =
		 * HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE); return
		 * builder.baseUrl("http://provider").clientConnector(new
		 * ReactorClientHttpConnector(httpClient)).build();
		 */
		return builder.baseUrl("http://provider").build();
	}

	/*
	 * @Bean WebClient webClient2(WebClient.Builder builder) {
	 * 
	 * // Use the code commented to change the resolver. WebClient uses Netty's //
	 * resolver which has issues with OS hostnames (like .mshome.net) This will use
	 * // JVM's resolver which isn't aync like Netty's but it works. And although it
	 * // may block the eventloop slightly it still is unblocking for the main
	 * request
	 * 
	 * HttpClient httpClient =
	 * HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE); return
	 * builder.baseUrl("http://provider").clientConnector(new
	 * ReactorClientHttpConnector(httpClient)).build();
	 * 
	 * }
	 */
}
