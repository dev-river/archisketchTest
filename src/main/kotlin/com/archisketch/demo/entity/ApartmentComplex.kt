package com.archisketch.demo.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "ApartmentComplex")
data class ApartmentComplex(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "apartmentComplex", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val addresses: List<Address> = emptyList()
)
