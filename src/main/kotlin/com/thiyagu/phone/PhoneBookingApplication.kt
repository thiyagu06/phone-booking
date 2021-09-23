package com.thiyagu.phone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import java.time.Duration


@SpringBootApplication
@EnableCaching
class PhoneBookingApplication {

	@Bean
	fun fonoApiClient(restTemplateBuilder: RestTemplateBuilder): RestTemplate {
		return restTemplateBuilder
			.setConnectTimeout(Duration.ofSeconds(10))
			.setReadTimeout(Duration.ofSeconds(10))
			.build()
	}
}

fun main(args: Array<String>) {
	runApplication<PhoneBookingApplication>(*args)
}


