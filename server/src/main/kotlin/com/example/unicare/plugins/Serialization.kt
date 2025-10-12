package com.example.unicare.plugins

import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import kotlinx.serialization.json.*

fun Application.configureSerialization(){
    install(ContentNegotiation){
        json( Json{
            prettyPrint = true
            isLenient = true
        })
    }
}