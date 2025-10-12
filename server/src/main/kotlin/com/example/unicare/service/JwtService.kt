package com.example.unicare.service
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.example.unicare.routing.request.LoginRequest
import com.typesafe.config.ConfigException
import io.ktor.server.application.Application
import io.ktor.server.auth.jwt.JWTCredential
import io.ktor.server.auth.jwt.JWTPrincipal
import java.util.Date

class JwtService (
    private val application: Application,
    private val userService: UserService
) {
//    private val secret = getConfigProperty("jwt.secret")
//    private val issuer = getConfigProperty("jwt.issuer")
//    private val audience = getConfigProperty("jwt.audience")
//    val realm = getConfigProperty("jwt.realm")
//    private val expiry = getConfigProperty("jwt.expiry")
    private val secret = "ALOT IS HAPPENING"
    private val issuer = "http://localhost:8080"
    private val audience = "http://localhost:8080"
    val realm = "Access protected routes"
    private val expiry = "86400000"
    private fun getConfigProperty(path: String) = application.environment.config.property(path).getString()

    val jwtVerifier: JWTVerifier = JWT.require(Algorithm.HMAC256(secret))
        .withAudience(audience).withIssuer(issuer).build()

    fun createJwtToken(loginRequest: LoginRequest): String? {
        val foundUser = userService.findByUsername(loginRequest.username)

        return if(foundUser != null && foundUser.password == loginRequest.password){
            JWT.create()
                .withAudience(audience)
                .withIssuer(issuer)
                .withClaim("username", foundUser.username)
                .withExpiresAt(Date(System.currentTimeMillis() + expiry.toLong()))
                .sign(Algorithm.HMAC256(secret))
        }else null
    }

    fun customValidator(credential: JWTCredential): JWTPrincipal ? {
        val userName = extractUsername(credential)
        val foundUser = userName?.let(userService::findByUsername)

        return foundUser?.let {
            if(audienceMatches(credential)) {
                return JWTPrincipal(credential.payload)
            } else {
                null
            }
        }
    }

    private fun audienceMatches(credential: JWTCredential): Boolean =
        credential.payload.audience.contains(audience)

    fun extractUsername(credential: JWTCredential): String? =
        credential.payload.getClaim("username").asString()

}