package com.malcolm.demo.isc.consumer.httpinterface;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/http-interface")
public class HttpInterfaceController {

	private final ProviderHttpInterface restClient;
	private final ProviderHttpInterface webClient;

	/**
	 * Used an explicit constructor instead of using Lombok so that I can use
	 * <code>@Qualifier</code>. It wouldn't have worked without because Spring
	 * injects using reflection and the fields are marked as final
	 * 
	 * @param restClient
	 * @param webClient
	 */
	public HttpInterfaceController(@Qualifier("restClientHttpInterface") ProviderHttpInterface restClient,
			@Qualifier("webClientHttpInterface") ProviderHttpInterface webClient) {
		this.restClient = restClient;
		this.webClient = webClient;
	}

	@GetMapping()
	public String getInstance() {
		return restClient.getInstanceInfo();
	}

	@GetMapping("/mono")
	public Mono<String> getInstanceAsMono() {
		return webClient.getInstanceInfoAsMono().map(s -> s.concat("<br> MONO"));
	}
}
