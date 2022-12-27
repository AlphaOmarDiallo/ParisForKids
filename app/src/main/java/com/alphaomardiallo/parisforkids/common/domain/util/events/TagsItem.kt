package com.alphaomardiallo.parisforkids.common.domain.util.events

import androidx.compose.ui.graphics.Color
import com.alphaomardiallo.parisforkids.R

sealed class TagsItem(
    var name: Int,
    var value: Int,
    var backgroundColor: Color,
    var contentColor: Color
) {
    object ContemporaryArt : TagsItem(
        name = R.string.tags_contemporary_art,
        value = R.string.tags_contemporary_art_value,
        backgroundColor = Color.Black,
        contentColor = Color.White
    )

    object Workshop : TagsItem(
        name = R.string.tags_contemporary_art,
        value = R.string.tags_contemporary_art_value,
        backgroundColor = Color.Black,
        contentColor = Color.White
    )
}
