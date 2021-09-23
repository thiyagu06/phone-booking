package com.thiyagu.phone.api

import com.thiyagu.phone.dto.PhoneBookingRequest
import com.thiyagu.phone.dto.PhoneDto
import com.thiyagu.phone.service.PhoneBookingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/phones")
class PhoneBookingController(@Autowired val phoneBookingService: PhoneBookingService) {

    @ResponseBody
    @GetMapping
    fun getAllPhone(): ResponseEntity<List<PhoneDto>> {
        return ResponseEntity(phoneBookingService.getAllPhones(), HttpStatus.OK)
    }

    @ResponseBody
    @PutMapping("/{id}/book")
    fun bookThePhone(
        @PathVariable id: Long,
        @RequestBody phoneBooingRequest: PhoneBookingRequest
    ): ResponseEntity<PhoneDto> {
        return ResponseEntity(phoneBookingService.book(id, phoneBooingRequest.name), HttpStatus.ACCEPTED)
    }

    @ResponseBody
    @PutMapping("/{id}/cancel")
    fun returnThePhone(@PathVariable id: Long): ResponseEntity<PhoneDto> {
        return ResponseEntity(phoneBookingService.cancel(id), HttpStatus.ACCEPTED)
    }
}


