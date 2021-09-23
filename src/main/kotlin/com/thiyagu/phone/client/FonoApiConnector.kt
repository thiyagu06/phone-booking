package com.thiyagu.phone.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class FonoApiConnector(@Autowired val restTemplate: RestTemplate) {

	@Value("\${fono.api.url}")
	private lateinit var fonoApiurl:String

	fun getPhoneInfo(brandName: String, modelName: String): FoneInfo {
		return getPhoneInfoCache(modelName)
	}

	@Cacheable(value = ["phoneInfo"], key = "{#modelName}")
	fun getPhoneInfoCache(modelName: String): FoneInfo {
		return try {
			restTemplate.getForObject("$fonoApiurl/${modelName.replace(" ","_")}", FoneInfo::class.java)!!
		} catch (e: Exception) {
			FoneInfo()
		}
	}
}

