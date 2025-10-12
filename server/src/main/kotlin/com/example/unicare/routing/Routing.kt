package com.example.unicare.routing

import com.example.unicare.service.JwtService
import com.example.unicare.service.UserService
import io.ktor.server.application.Application
import io.ktor.server.routing.*

fun Application.configureRouting(
    userService: UserService,
    jwtService: JwtService
){
    routing{
        route("/api/auth"){
            authRoute(jwtService)
        }
        route("/api/user"){
            userRoute(userService)
        }
    }
}