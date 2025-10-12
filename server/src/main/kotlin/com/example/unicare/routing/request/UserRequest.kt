package com.example.unicare.routing.request

import kotlinx.serialization.*

@Serializable
data class UserRequest(
    val username: String,
    val password: String
)