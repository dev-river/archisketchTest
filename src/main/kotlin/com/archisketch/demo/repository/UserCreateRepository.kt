package com.archisketch.demo.repository

import com.archisketch.demo.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserCreateRepository : JpaRepository<User, Long>