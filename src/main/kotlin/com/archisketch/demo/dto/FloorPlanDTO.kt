package com.archisketch.demo.dto

import com.archisketch.demo.entity.FloorPlan
import com.querydsl.core.annotations.QueryProjection

data class FloorPlanDTO @QueryProjection constructor(
    val complexName: String,
    val unitName: String,
    val exclusiveArea: Double,
    val isExtended: Boolean,
    val imageUrl: String
) {
    companion object {
        fun from(plan: FloorPlan): FloorPlanDTO = FloorPlanDTO(
            complexName = plan.unitType.apartmentComplex.name,
            unitName = plan.unitType.name,
            exclusiveArea = plan.unitType.exclusiveArea,
            isExtended = plan.unitType.isExtended,
            imageUrl = plan.imageUrl
        )
    }
}