package com.archisketch.demo.repository

import com.archisketch.demo.entity.FloorPlan

interface FloorPlanRepository{
    fun searchFloorPlans(
        name: String?,
        addressType: String?,
        addressKeyword: String?,
        exclusiveAreaSort: String?,
        isExtended: Int?,
        unitName: String?
    ): List<FloorPlan>
}