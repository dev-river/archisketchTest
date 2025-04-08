package com.archisketch.demo.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.archisketch.demo.service.FloorPlanService
import com.archisketch.demo.dto.FloorPlanDTO

@RestController
@RequestMapping("/floorPlans")
class FloorPlanController(
    private val floorPlanService: FloorPlanService
) {
    @GetMapping("/search")
    fun search(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) addressType: String?,
        @RequestParam(required = false) addressKeyword: String?,
        @RequestParam(required = false) exclusiveAreaSort: String?,
        @RequestParam(required = false) isExtended: Int?,
        @RequestParam(required = false) unitName: String?
    ): ResponseEntity<List<FloorPlanDTO>> {
        val results = floorPlanService.searchFloorPlans(
            name, addressType, addressKeyword, exclusiveAreaSort, isExtended, unitName
        )
        return ResponseEntity.ok(results)
    }
}