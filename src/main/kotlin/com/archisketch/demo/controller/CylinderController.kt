package com.archisketch.demo.controller

import com.archisketch.demo.dto.CylinderResponse
import com.archisketch.demo.dto.OpenApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class CylinderController {

    private val restTemplate = RestTemplate()

    @GetMapping("/cylinder")
    fun getCylinderInfo(): CylinderResponse {
        val url = "https://api.archisketch.com/v1/public/product/YB0Njg-02923BC5C1A84C59"
        val response = restTemplate.getForObject(url, OpenApiResponse::class.java)
        return CylinderResponse(
            name = response?.product?.name ?: "Unknown",
            editorAsset = response?.product?.editorAsset ?: error("editorAsset not found")
        )
    }
}