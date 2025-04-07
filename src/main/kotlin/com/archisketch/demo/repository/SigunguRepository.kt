package com.archisketch.demo.repository

import com.archisketch.demo.entity.Sigungu
import org.springframework.data.jpa.repository.JpaRepository

interface SigunguRepository : JpaRepository<Sigungu, Long> {
    fun findAllByPidLocCode(pidLocCode: Long): List<Sigungu>
}