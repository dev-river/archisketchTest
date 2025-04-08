package com.archisketch.demo.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "UnitType")
data class UnitType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complexId")
    val apartmentComplex: ApartmentComplex,

    val name: String,                  // 예: "112B"
    val supplyArea: Double,           // 공급면적
    val exclusiveArea: Double,        // 전용면적
    @Column(name = "isExtended", columnDefinition = "TINYINT(1)")
    val isExtended: Boolean,          // 확장형 여부 0:basic 1:Extended

    val createdAt: LocalDateTime = LocalDateTime.now()
)