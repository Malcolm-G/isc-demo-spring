package com.malcolm.demo.isc.consumer.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/feign")
@RequiredArgsConstructor
public class FeignController {

	private final ProviderFeignClient providerFeignClient;

	@GetMapping()
	public String getInstance() {
		return providerFeignClient.getInstanceInfo();
	}
}
