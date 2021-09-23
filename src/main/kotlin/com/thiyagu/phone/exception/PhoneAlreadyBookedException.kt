package com.thiyagu.phone.exception

class PhoneAlreadyBookedException(val id: Long, val bookedBy: String) : RuntimeException("phone not found with id=$id")