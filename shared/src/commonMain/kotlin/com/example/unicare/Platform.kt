package com.example.unicare

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform