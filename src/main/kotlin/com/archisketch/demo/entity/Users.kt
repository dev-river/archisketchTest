package com.archisketch.demo.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val password: String,

    @Column(name = "createdAt")
    val createdAt: LocalDateTime = LocalDateTime.now()
)
