package com.thiyagu.phone.repository

import com.thiyagu.phone.model.Phone
import org.springframework.data.repository.CrudRepository

interface PhoneRepository : CrudRepository<Phone, Long>