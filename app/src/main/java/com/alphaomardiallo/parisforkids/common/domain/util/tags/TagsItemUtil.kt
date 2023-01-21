package com.alphaomardiallo.parisforkids.common.domain.util.tags

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.alphaomardiallo.parisforkids.R
import com.alphaomardiallo.parisforkids.common.ui.theme.*

fun formatToTag(tags: String?, context: Context): TagsItem? {
    if (tags.isNullOrBlank()) {
        return null
    } else {
        when (tags) {
            context.getString(TagsItem.ContemporaryArt.value) -> return TagsItem.ContemporaryArt
            context.getString(TagsItem.Workshop.value) -> return TagsItem.Workshop
            context.getString(TagsItem.Comics.value) -> return TagsItem.Comics
            context.getString(TagsItem.Stroll.value) -> return TagsItem.Stroll
            context.getString(TagsItem.Cinema.value) -> return TagsItem.Cinema
            context.getString(TagsItem.Circus.value) -> return TagsItem.Circus
            context.getString(TagsItem.Concert.value) -> return TagsItem.Concert
            context.getString(TagsItem.Dance.value) -> return TagsItem.Dance
            context.getString(TagsItem.Exhibition.value) -> return TagsItem.Exhibition
            context.getString(TagsItem.Gourmand.value) -> return TagsItem.Gourmand
            context.getString(TagsItem.History.value) -> return TagsItem.History
            context.getString(TagsItem.Humor.value) -> return TagsItem.Humor
            context.getString(TagsItem.Innovation.value) -> return TagsItem.Innovation
            context.getString(TagsItem.LGBT.value) -> return TagsItem.LGBT
            context.getString(TagsItem.Literature.value) -> return TagsItem.Literature
            context.getString(TagsItem.Music.value) -> return TagsItem.Music
            context.getString(TagsItem.Nature.value) -> return TagsItem.Nature
            context.getString(TagsItem.Leisure.value) -> return TagsItem.Leisure
            context.getString(TagsItem.Painting.value) -> return TagsItem.Painting
            context.getString(TagsItem.Photo.value) -> return TagsItem.Photo
            context.getString(TagsItem.Show.value) -> return TagsItem.Show
            context.getString(TagsItem.Health.value) -> return TagsItem.Health
            context.getString(TagsItem.Science.value) -> return TagsItem.Science
            context.getString(TagsItem.Solidarity.value) -> return TagsItem.Solidarity
            context.getString(TagsItem.Musical.value) -> return TagsItem.Musical
            context.getString(TagsItem.Sport.value) -> return TagsItem.Sport
            context.getString(TagsItem.StreetArt.value) -> return TagsItem.StreetArt
            context.getString(TagsItem.Theatre.value) -> return TagsItem.Theatre
            else -> return null
        }
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
        backgroundColor = Color.Gray,
        contentColor = Color.Black
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
        contentColor = Color.Black
    )

    object Cinema : TagsItem(
        name = R.string.tags_cinema,
        value = R.string.tags_cinema_value,
        backgroundColor = Color.DarkGray,
        contentColor = Color.White
    )

    object Circus : TagsItem(
        name = R.string.tags_circus,
        value = R.string.tags_circus_value,
        backgroundColor = Color.Red,
        contentColor = Color.Black
    )

    object Concert : TagsItem(
        name = R.string.tags_concert,
        value = R.string.tags_concert_value,
        backgroundColor = Color.Yellow,
        contentColor = Color.Black
    )

    object Dance : TagsItem(
        name = R.string.tags_dance,
        value = R.string.tags_dance_value,
        backgroundColor = Color.Magenta,
        contentColor = Color.White
    )

    object Exhibition : TagsItem(
        name = R.string.tags_exhibition,
        value = R.string.tags_exhibition_value,
        backgroundColor = Color.White,
        contentColor = Color.Black
    )

    object Gourmand : TagsItem(
        name = R.string.tags_gourmand,
        value = R.string.tags_gourmand_value,
        backgroundColor = colorBrown,
        contentColor = Color.White
    )

    object History : TagsItem(
        name = R.string.tags_history,
        value = R.string.tags_history_value,
        backgroundColor = colorBlueGrey,
        contentColor = Color.White
    )

    object Humor : TagsItem(
        name = R.string.tags_humor,
        value = R.string.tags_humor_value,
        backgroundColor = colorDeepOrange,
        contentColor = Color.White
    )

    object Innovation : TagsItem(
        name = R.string.tags_innovation,
        value = R.string.tags_innovation_value,
        backgroundColor = colorLimeLight,
        contentColor = Color.Black
    )

    object LGBT : TagsItem(
        name = R.string.tags_lgbt,
        value = R.string.tags_lgbt_value,
        backgroundColor = colorDeepPurple,
        contentColor = Color.White
    )

    object Literature : TagsItem(
        name = R.string.tags_literature,
        value = R.string.tags_literature_value,
        backgroundColor = colorLightBlue,
        contentColor = Color.Black
    )

    object Leisure : TagsItem(
        name = R.string.tags_leisure,
        value = R.string.tags_leisure_value,
        backgroundColor = colorAmber,
        contentColor = Color.Black
    )

    object Music : TagsItem(
        name = R.string.tags_music,
        value = R.string.tags_music_value,
        backgroundColor = secondaryLightColor,
        contentColor = Color.Black
    )

    object Nature : TagsItem(
        name = R.string.tags_nature,
        value = R.string.tags_nature_value,
        backgroundColor = Color.Green,
        contentColor = Color.Black
    )

    object Painting : TagsItem(
        name = R.string.tags_painting,
        value = R.string.tags_painting_value,
        backgroundColor = secondaryDarkColor,
        contentColor = Color.Black
    )

    object Photo : TagsItem(
        name = R.string.tags_photo,
        value = R.string.tags_photo_value,
        backgroundColor = bottomBarItems,
        contentColor = Color.Black
    )

    object Show : TagsItem(
        name = R.string.tags_show,
        value = R.string.tags_show_value,
        backgroundColor = bottomBar,
        contentColor = Color.White
    )

    object Health : TagsItem(
        name = R.string.tags_health,
        value = R.string.tags_health_value,
        backgroundColor = appBar,
        contentColor = Color.White
    )

    object Science : TagsItem(
        name = R.string.tags_science,
        value = R.string.tags_science_value,
        backgroundColor = colorDarkDeepPurple,
        contentColor = Color.White
    )

    object Solidarity : TagsItem(
        name = R.string.tags_solidarity,
        value = R.string.tags_solidarity_value,
        backgroundColor = colorPurple,
        contentColor = Color.Black
    )

    object Musical : TagsItem(
        name = R.string.tags_musical,
        value = R.string.tags_musical_value,
        backgroundColor = colorYellow,
        contentColor = Color.Black
    )

    object Sport : TagsItem(
        name = R.string.tags_sport,
        value = R.string.tags_sport_value,
        backgroundColor = colorGreen,
        contentColor = Color.Black
    )

    object StreetArt : TagsItem(
        name = R.string.tags_street_art,
        value = R.string.tags_street_art_value,
        backgroundColor = colorDarkGrey,
        contentColor = Color.White
    )

    object Theatre : TagsItem(
        name = R.string.tags_theater,
        value = R.string.tags_theatre_value,
        backgroundColor = colorPink,
        contentColor = Color.Black
    )

}
