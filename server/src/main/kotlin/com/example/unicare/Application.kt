package com.example.unicare

import com.example.unicare.plugins.configureSecurity
import com.example.unicare.plugins.configureSerialization
import com.example.unicare.repository.UserRepository
import com.example.unicare.routing.configureRouting
import com.example.unicare.service.JwtService
import com.example.unicare.service.UserService
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.config.HoconApplicationConfig
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    val config = ConfigFactory.load()

    embeddedServer(Netty,port = SERVER_PORT, host = "localhost", module = Application::module)
        .start(wait = true)
}


//fun main() {
//    val config = HoconApplicationConfig(ConfigFactory.load())
//
//    val environment = applicationEngineEnvironment {
//        config(config)
//        module {
//            module() // This refers to your Application.module function
//        }
//        connector {
//            port = 8080
//            host = "0.0.0.0"
//        }
//    }
//
//    embeddedServer(Netty, environment).start(wait = true)
//}


fun Application.module() {

    val userRepository = UserRepository()
    val userService = UserService(userRepository)
    val jwtService = JwtService(this, userService)
    configureSecurity(jwtService)
    configureSerialization()
    configureRouting(userService, jwtService)


}