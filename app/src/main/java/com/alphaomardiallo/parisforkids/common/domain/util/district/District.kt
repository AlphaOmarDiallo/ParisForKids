package com.alphaomardiallo.parisforkids.common.domain.util.district

import android.content.Context
import com.alphaomardiallo.parisforkids.R

fun formatDistrict(district: String?, context: Context): District? {
    if (district == null){
        return null
    } else {
        when (district) {
            context.getString(District.Paris1.name) -> return District.Paris1
            context.getString(District.Paris2.name) -> return District.Paris2
            context.getString(District.Paris3.name) -> return District.Paris3
            context.getString(District.Paris4.name) -> return District.Paris4
            context.getString(District.Paris5.name) -> return District.Paris5
            context.getString(District.Paris6.name) -> return District.Paris6
            context.getString(District.Paris7.name) -> return District.Paris7
            context.getString(District.Paris8.name) -> return District.Paris8
            context.getString(District.Paris9.name) -> return District.Paris9
            context.getString(District.Paris10.name) -> return District.Paris10
            context.getString(District.Paris11.name) -> return District.Paris11
            context.getString(District.Paris12.name) -> return District.Paris12
            context.getString(District.Paris13.name) -> return District.Paris13
            context.getString(District.Paris14.name) -> return District.Paris14
            context.getString(District.Paris15.name) -> return District.Paris15
            context.getString(District.Paris16.name) -> return District.Paris16
            context.getString(District.Paris17.name) -> return District.Paris17
            context.getString(District.Paris18.name) -> return District.Paris18
            context.getString(District.Paris19.name) -> return District.Paris19
            context.getString(District.Paris20.name) -> return District.Paris20
            else -> return null
        }
    }
}

sealed class District(
    var name: Int,
    var displayName: Int
) {
    object Paris1 : District(
        name = R.string.district_1,
        displayName = R.string.district_1_value
    )

    object Paris2 : District(
        name = R.string.district_2,
        displayName = R.string.district_2_value
    )

    object Paris3 : District(
        name = R.string.district_3,
        displayName = R.string.district_3_value
    )

    object Paris4 : District(
        name = R.string.district_4,
        displayName = R.string.district_4_value
    )

    object Paris5 : District(
        name = R.string.district_5,
        displayName = R.string.district_5_value
    )

    object Paris6 : District(
        name = R.string.district_6,
        displayName = R.string.district_6_value
    )

    object Paris7 : District(
        name = R.string.district_7,
        displayName = R.string.district_7_value
    )

    object Paris8 : District(
        name = R.string.district_8,
        displayName = R.string.district_8_value
    )

    object Paris9 : District(
        name = R.string.district_9,
        displayName = R.string.district_9_value
    )

    object Paris10 : District(
        name = R.string.district_10,
        displayName = R.string.district_10_value
    )

    object Paris11 : District(
        name = R.string.district_11,
        displayName = R.string.district_11_value
    )

    object Paris12 : District(
        name = R.string.district_12,
        displayName = R.string.district_12_value
    )

    object Paris13 : District(
        name = R.string.district_13,
        displayName = R.string.district_13_value
    )

    object Paris14 : District(
        name = R.string.district_14,
        displayName = R.string.district_14_value
    )

    object Paris15 : District(
        name = R.string.district_15,
        displayName = R.string.district_15_value
    )

    object Paris16 : District(
        name = R.string.district_16,
        displayName = R.string.district_16_value
    )

    object Paris17 : District(
        name = R.string.district_17,
        displayName = R.string.district_17_value
    )

    object Paris18 : District(
        name = R.string.district_18,
        displayName = R.string.district_18_value
    )

    object Paris19 : District(
        name = R.string.district_19,
        displayName = R.string.district_19_value
    )

    object Paris20 : District(
        name = R.string.district_20,
        displayName = R.string.district_20_value
    )
}
