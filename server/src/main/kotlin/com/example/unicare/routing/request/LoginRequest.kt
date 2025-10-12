package com.example.unicare.routing.request

import io.ktor.server.auth.UserPasswordCredential
import kotlinx.serialization.Serializable
import javax.print.attribute.standard.RequestingUserName
@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)