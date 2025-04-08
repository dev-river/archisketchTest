package com.archisketch.demo.entity

import jakarta.persistence.*

@Entity
@Table(name = "Address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complexId")
    val apartmentComplex: ApartmentComplex,

    @Enumerated(EnumType.STRING)
    val type: AddressType, // 'ROAD', 'JIBUN'

    val fullAddress: String
)

enum class AddressType {
    ROAD, JIBUN
}