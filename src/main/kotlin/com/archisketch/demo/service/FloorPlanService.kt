package com.archisketch.demo.service

import com.archisketch.demo.dto.FloorPlanDTO
import com.archisketch.demo.repository.FloorPlanRepository
import org.springframework.stereotype.Service

@Service
class FloorPlanService(
    private val floorPlanRepository: FloorPlanRepository
) {
    fun searchFloorPlans(
        name: String?,
        addressType: String?,
        addressKeyword: String?,
        exclusiveAreaSort: String?,
        isExtended: Int?,
        unitName: String?
    ): List<FloorPlanDTO> {
        val results = floorPlanRepository.searchFloorPlans(
            name, addressType, addressKeyword, exclusiveAreaSort, isExtended, unitName
        )

        val sorted = when (exclusiveAreaSort?.lowercase()) {
            "asc" -> results.sortedBy { it.unitType.exclusiveArea }
            "desc" -> results.sortedByDescending { it.unitType.exclusiveArea }
            else -> results
        }

        return sorted.map { FloorPlanDTO.from(it) }
    }
}