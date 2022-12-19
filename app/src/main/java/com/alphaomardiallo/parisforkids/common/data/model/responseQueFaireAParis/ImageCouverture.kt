package com.alphaomardiallo.parisforkids.common.data.model.responseQueFaireAParis

data class ImageCouverture(
    val color_summary: List<String>,
    val filename: String,
    val format: String,
    val height: Int,
    val id: String,
    val mimetype: String,
    val thumbnail: Boolean,
    val width: Int
)