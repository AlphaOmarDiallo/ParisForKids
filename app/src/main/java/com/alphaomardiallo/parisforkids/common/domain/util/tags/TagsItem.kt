package com.alphaomardiallo.parisforkids.common.domain.util.tags

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.alphaomardiallo.parisforkids.R

fun formatToTag(tags: String?, context: Context) : TagsItem?{
    when (tags) {
        context.getString(TagsItem.ContemporaryArt.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Workshop.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Comics.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Stroll.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Cinema.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Circus.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Concert.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Dance.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Kids.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Exhibition.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Gourmand.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.History.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Humor.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Innovation.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.LGBT.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Literature.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Music.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Nature.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Leisure.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Painting.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Photo.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Show.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Health.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Science.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Solidarity.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Musical.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Sport.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.StreetArt.value) -> return TagsItem.ContemporaryArt
        context.getString(TagsItem.Theatre.value) -> return TagsItem.ContemporaryArt
        else -> return null
    }
}

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
        name = R.string.tags_workshop,
        value = R.string.tags_workshop_value,
        backgroundColor = Color.Cyan,
        contentColor = Color.White
    )

    object Comics : TagsItem(
        name = R.string.tags_comics,
        value = R.string.tags_comics_value,
        backgroundColor = Color.Blue,
        contentColor = Color.White
    )

    object Stroll : TagsItem(
        name = R.string.tags_stroll,
        value = R.string.tags_stroll_value,
        backgroundColor = Color.Green,
        contentColor = Color.White
    )

    object Cinema : TagsItem(
        name = R.string.tags_cinema,
        value = R.string.tags_cinema_value,
        backgroundColor = Color.Cyan,
        contentColor = Color.White
    )

    object Circus : TagsItem(
        name = R.string.tags_circus,
        value = R.string.tags_circus_value,
        backgroundColor = Color.Red,
        contentColor = Color.White
    )

    object Concert : TagsItem(
        name = R.string.tags_concert,
        value = R.string.tags_concert_value,
        backgroundColor = Color.Yellow,
        contentColor = Color.White
    )

    object Dance : TagsItem(
        name = R.string.tags_dance,
        value = R.string.tags_dance_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Kids : TagsItem(
        name = R.string.tags_kids,
        value = R.string.tags_kids_value,
        backgroundColor = Color.White,
        contentColor = Color.Black
    )

    object Exhibition : TagsItem(
        name = R.string.tags_exhibition,
        value = R.string.tags_exhibition_value,
        backgroundColor = Color.DarkGray,
        contentColor = Color.White
    )

    object Gourmand : TagsItem(
        name = R.string.tags_gourmand,
        value = R.string.tags_gourmand_value,
        backgroundColor = Color.Gray,
        contentColor = Color.White
    )

    object History : TagsItem(
        name = R.string.tags_history,
        value = R.string.tags_history_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Humor : TagsItem(
        name = R.string.tags_humor,
        value = R.string.tags_humor_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Innovation : TagsItem(
        name = R.string.tags_innovation,
        value = R.string.tags_innovation_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object LGBT : TagsItem(
        name = R.string.tags_lgbt,
        value = R.string.tags_lgbt_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Literature : TagsItem(
        name = R.string.tags_literature,
        value = R.string.tags_literature_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Leisure : TagsItem(
        name = R.string.tags_leisure,
        value = R.string.tags_leisure_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Music : TagsItem(
        name = R.string.tags_music,
        value = R.string.tags_music_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Nature : TagsItem(
        name = R.string.tags_nature,
        value = R.string.tags_nature_value,
        backgroundColor = Color.Green,
        contentColor = Color.White
    )

    object Painting : TagsItem(
        name = R.string.tags_painting,
        value = R.string.tags_painting_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Photo : TagsItem(
        name = R.string.tags_photo,
        value = R.string.tags_photo_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Show : TagsItem(
        name = R.string.tags_show,
        value = R.string.tags_show_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Health : TagsItem(
        name = R.string.tags_health,
        value = R.string.tags_health_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Science : TagsItem(
        name = R.string.tags_science,
        value = R.string.tags_science_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Solidarity : TagsItem(
        name = R.string.tags_solidarity,
        value = R.string.tags_solidarity_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Musical : TagsItem(
        name = R.string.tags_musical,
        value = R.string.tags_musical_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Sport : TagsItem(
        name = R.string.tags_sport,
        value = R.string.tags_sport_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object StreetArt : TagsItem(
        name = R.string.tags_street_art,
        value = R.string.tags_street_art_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Theatre : TagsItem(
        name = R.string.tags_theater,
        value = R.string.tags_theatre_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

}
