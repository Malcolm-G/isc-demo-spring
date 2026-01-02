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

	/**
	 * We are using the load-balanced bean defined at
	 * {@link com.malcolm.demo.isc.consumer.webclient.WebClientConfig#loadBalancedWebClientBuilder()}
	 * <br>
	 * <br>
	 * You can define another loadBalanced WebClient Builder bean but use @Qualifier
	 * or @Primary
	 * 
	 * @param loadBalancedRestClientBuilder
	 * @return
	 */
	@Bean
	ProviderHttpInterface webClientHttpInterface(WebClient.Builder builder) {
		WebClient webClient = builder.baseUrl("http://provider").build();
		WebClientAdapter adapter = WebClientAdapter.create(webClient);
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
		ProviderHttpInterface service = factory.createClient(ProviderHttpInterface.class);
		return service;
	}

	/**
	 * We are using the load-balanced bean defined at
	 * {@link com.malcolm.demo.isc.consumer.restclient.RestClientConfig#loadBalancedRestClientBuilder()}
	 * <br>
	 * <br>
	 * You can define another loadBalanced RestClient Builder bean but
	 * use @Qualifier or @Primary
	 * 
	 * @param loadBalancedRestClientBuilder
	 * @return
	 */
	@Bean
	ProviderHttpInterface restClientHttpInterface(RestClient.Builder loadBalancedRestClientBuilder) {
		RestClient restClient = loadBalancedRestClientBuilder.baseUrl("http://provider").build();
		RestClientAdapter adapter = RestClientAdapter.create(restClient);
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
		ProviderHttpInterface service = factory.createClient(ProviderHttpInterface.class);
		return service;
	}
}
