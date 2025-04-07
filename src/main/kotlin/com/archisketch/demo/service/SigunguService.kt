package com.archisketch.demo.service
import com.archisketch.demo.dto.SigunguDTO
import com.archisketch.demo.repository.SigunguRepository
import org.springframework.stereotype.Service

@Service
class SigunguService(
    private val sigunguRepository: SigunguRepository
) {
    fun getSigunguByPidLocCode(pidLocCode: Long): List<SigunguDTO> {
        return sigunguRepository.findAllByPidLocCode(pidLocCode).map {
            SigunguDTO(
                pidLocCode = it.pidLocCode,
                level = it.level,
                depth1 = it.depth1,
                depth2 = it.depth2,
                depth3 = it.depth3,
                ltLng = it.ltLng,
                ltLat = it.ltLat,
                rbLng = it.rbLng,
                rbLat = it.rbLat,
                dateCreation = it.dateCreation.toString()
            )
        }
    }
}