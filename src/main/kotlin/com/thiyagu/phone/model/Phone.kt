package com.thiyagu.phone.model

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Phone(
    val model: String,
    val brand: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var isAvailable: Boolean = true,
    var bookedBy: String? = null,
    var bookedOn: Instant? = null,
)