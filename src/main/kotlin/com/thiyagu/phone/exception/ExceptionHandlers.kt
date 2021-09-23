package com.thiyagu.phone.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlers {
    @ExceptionHandler(PhoneAlreadyBookedException::class)
    fun handlePhoneAlreadyBookedException(ex: PhoneAlreadyBookedException): ResponseEntity<String> {
        return ResponseEntity("phone with id: ${ex.id} is already booked by ${ex.bookedBy}", HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity("not found", HttpStatus.NOT_FOUND)
    }
}
