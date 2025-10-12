package com.example.unicare.repository
import java.util.UUID
import com.example.unicare.model.User


class UserRepository {

    private val users = mutableListOf<User>()
    fun findAll(): List<User> = users
    fun findById(id:UUID): User? = users.firstOrNull{ it.id == id}
    fun findByUserName(username: String): User? = users.firstOrNull { it.username == username }
    fun save(user: User): Boolean = users.add(user)

}