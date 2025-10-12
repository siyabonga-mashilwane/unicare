package com.example.unicare

import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import Navigation.AppRouter

@Composable
fun App(){
    MaterialTheme {
        AppRouter()
    }
}