package com.thiyagu.phone.service

import com.thiyagu.phone.client.FonoApiConnector
import com.thiyagu.phone.dto.PhoneDto
import com.thiyagu.phone.exception.PhoneAlreadyBookedException
import com.thiyagu.phone.model.Phone
import com.thiyagu.phone.repository.PhoneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant

@Service
class PhoneBookingService(
    @Autowired private val phoneRepository: PhoneRepository,
    @Autowired private val fonoApiClient: FonoApiConnector
) {

    fun getAllPhones(): List<PhoneDto> {
        return phoneRepository.findAll().map {
            toPhoneDto(it)
        }.toList()
    }

    fun book(phoneId: Long, bookedBy: String): PhoneDto {
        val phone = phoneRepository.findById(phoneId).orElseThrow()
        if (canBook(phone)) {
            phone.bookedBy = bookedBy
            phone.bookedOn = Instant.now()
            phone.isAvailable = false
            val phoneBooked = phoneRepository.save(phone)
            return toPhoneDto(phoneBooked)
        }
        throw PhoneAlreadyBookedException(phoneId, phone.bookedBy!!)
    }

    fun cancel(phoneId: Long): PhoneDto {
        val phone = phoneRepository.findById(phoneId).orElseThrow()
        phone.bookedBy = null
        phone.isAvailable = true
        phone.bookedOn = null
        val phoneReturned = phoneRepository.save(phone)
        return toPhoneDto(phoneReturned)
    }

    private fun toPhoneDto(phone: Phone): PhoneDto {
        return PhoneDto(
            phone.brand,
            phone.model,
            phone.isAvailable,
            phone.bookedBy,
            phone.bookedOn,
            fonoApiClient.getPhoneInfo(phone.brand, phone.model)
        )
    }

    private fun canBook(phone: Phone): Boolean {
        return phone.isAvailable
    }
}