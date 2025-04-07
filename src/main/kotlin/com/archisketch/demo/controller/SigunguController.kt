package com.archisketch.demo.controller

import com.archisketch.demo.dto.SigunguDTO
import com.archisketch.demo.service.SigunguService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sigungu")
class SigunguController(
    private val sigunguService: SigunguService
) {

    @GetMapping
    fun getSigungu(@RequestParam pid_loc_code: Long): List<SigunguDTO> {
        return sigunguService.getSigunguByPidLocCode(pid_loc_code)
    }
}