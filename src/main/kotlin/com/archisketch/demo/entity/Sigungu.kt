package com.archisketch.demo.entity
import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "Sigungu")
data class Sigungu(
    @Id
    @Column(name = "pid_loc_code")
    val pidLocCode: Long,

    val level: Int,
    val depth1: String,
    val depth2: String,
    val depth3: String,
    @Column(name = "lt_lng")
    val ltLng: Double,
    @Column(name = "lt_lat")
    val ltLat: Double,
    @Column(name = "rb_lng")
    val rbLng: Double,
    @Column(name = "rb_lat")
    val rbLat: Double,
    @Column(name = "date_creation")
    val dateCreation: Timestamp
) {
    constructor() : this(
        0L, 0, "", "", "", 0.0, 0.0, 0.0, 0.0, Timestamp(0)
    )
}