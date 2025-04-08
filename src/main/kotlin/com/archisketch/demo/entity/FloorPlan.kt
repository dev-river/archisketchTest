package com.archisketch.demo.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "FloorPlan")
data class FloorPlan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartmentComplexId")
    val apartmentComplex: ApartmentComplex,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unitTypeId")
    val unitType: UnitType,

    val imageUrl: String,

    val createdAt: LocalDateTime = LocalDateTime.now()
)
