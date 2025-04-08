package com.archisketch.demo.controller

import com.archisketch.demo.dto.CreateUserRequest
import com.archisketch.demo.entity.User
import com.archisketch.demo.repository.UserCreateRepository
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/user")
class UserController(
    private val userCreateRepository: UserCreateRepository
) {
    @PostMapping
    fun createUser(@RequestBody request: CreateUserRequest): Map<String, Any> {
        val user = User(
            name = request.name,
            password = request.password,
            createdAt = LocalDateTime.now()
        )
        val saved = userCreateRepository.save(user)
        return mapOf(
            "message" to "User successfully created",
            "user" to saved
        )
    }
}