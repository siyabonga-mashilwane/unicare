package com.example.unicare

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.auth.*
import io.ktor.server.response.respondText
import java.util.Date

fun Application.configureJWTAuthentication(config: JWTConfig){
    install(Authentication){
        jwt("jwt-auth"){
            realm = config.realm
            val jwtVerifier = JWT
                .require(Algorithm.HMAC256(config.secret))
                .withAudience(config.audience)
                .withIssuer(config.issuer)
                .build()
            verifier(jwtVerifier)

            validate {
                jwtCredential ->
                val userName = jwtCredential.payload.getClaim("username").asString()
                if (!userName.isNullOrBlank()){
                    JWTPrincipal(jwtCredential.payload)
                }else{
                    null
                }
            }
//            challenge { defaultScheme, realm ->
//                call.respondText ( "Token is valid or token has expired",
//                    status = HttpStatusCode.Unauthorized
//                )
//            }
            challenge { _, _ ->
                call.respondText ( "Token is valid or token has expired",
                    status = HttpStatusCode.Unauthorized
                )
            }

        }
    }
}

fun generateToken(config: JWTConfig, username:String ):String{
    return JWT.create()
        .withAudience(config.audience)
        .withIssuer(config.issuer)
        .withClaim("username", username)
        .withExpiresAt(Date(System.currentTimeMillis() + config.tokenExpiry))
        .sign(Algorithm.HMAC256(config.secret))
}

data class JWTConfig(
    val secret:String,
    val issuer:String,
    val audience:String,
    val realm:String,
    val tokenExpiry:Long
)