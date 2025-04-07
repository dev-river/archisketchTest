package com.archisketch.demo.dto

data class OpenApiResponse(
    val product: Product
)

data class Product(
    val name: String,
    val editorAsset: EditorAsset
)