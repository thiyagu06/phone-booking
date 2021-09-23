package com.thiyagu.phone

import com.thiyagu.phone.exception.PhoneAlreadyBookedException
import com.thiyagu.phone.service.PhoneBookingService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PhoneBookingApplicationTests {

	@Autowired
	lateinit var phoneBookingService: PhoneBookingService

	@Test
	fun `should be able to book the phone when it is available for booking`() {
		val phoneBooked = phoneBookingService.book(1, "john")
		assertThat(phoneBooked.bookedBy.equals("john")).isTrue
		assertThat(phoneBooked.isAvailable).isFalse
	}

	@Test
	fun `should throw PhoneAlreadyBookedException when booking a already booked mobile`() {
		phoneBookingService.book(2, "john")
		assertThrows<PhoneAlreadyBookedException> { phoneBookingService.book(2, "test") }
	}

	@Test
	fun `should be able to cancel the booking of an mobile`(){
		val phoneBooked = phoneBookingService.book(3, "test")
		assertThat(phoneBooked.isAvailable).isFalse
		val phoneReturned = phoneBookingService.cancel(3)
		assertThat(phoneReturned.isAvailable).isTrue
	}
}
