package com.example.unicare.plugins

import com.example.unicare.service.JwtService
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.authentication
import io.ktor.server.auth.jwt.jwt

fun Application.configureSecurity(
    jwtService: JwtService
){
    authentication {
        jwt {
            realm = jwtService.realm
            verifier (jwtService.jwtVerifier)
            validate {
                credential -> jwtService.customValidator(credential)
            }
        }
    }

}