package com.example.unicare.routing.response

import com.example.unicare.util.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID


@Serializable
data class UserResponse (
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val userName: String
)