package com.thiyagu.phone.dto

import com.thiyagu.phone.client.FoneInfo
import java.time.Instant

data class PhoneDto(
    val brand: String,
    val model: String,
    val isAvailable: Boolean,
    val bookedBy: String?,
    val bookedOn: Instant?,
    val foneInfo: FoneInfo
)