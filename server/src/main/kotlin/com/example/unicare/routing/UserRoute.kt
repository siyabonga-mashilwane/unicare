package com.example.unicare.routing

import com.example.unicare.model.User
import com.example.unicare.routing.request.*
import com.example.unicare.routing.response.UserResponse
import com.example.unicare.service.UserService
import io.ktor.http.HttpStatusCode
import io.ktor.server.auth.authenticate
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Route.userRoute(userService: UserService){
    post {
        val userRequest = call.receive<UserRequest>()
//        val userRequest = call.receiveText()
//        println(userRequest)
        val createdUser = userService.save(
            user = userRequest.toModel()
        ) ?: return@post call.respond(HttpStatusCode.BadRequest)

        call.response.header(
            name = "id",
            value = createdUser.id.toString()
        )
        call.respond(
            message = HttpStatusCode.Created
        )
    }
    get {
        val users = userService.findAll()

        call.respond(
            message = users.map(User::toResponse)
        )
    }
    get("/{id}"){
        val id: String = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest)
        val foundUser = userService.findById(id) ?: return@get call.respond(HttpStatusCode.NotFound)
        call.respond(
            message = foundUser.toResponse()
        )
    }

}
private fun UserRequest.toModel(): User = User(
    id = UUID.randomUUID(),
    username = this.username,
    password = this.password,
)

private fun User.toResponse(): UserResponse = UserResponse(
    id = this.id,
    userName = this.username,
)