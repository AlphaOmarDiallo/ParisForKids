package com.alphaomardiallo.parisforkids.domain

import java.text.SimpleDateFormat
import java.util.*

object DateUtil{
    private val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE)

    fun createDate() : String {
        val currentDate = sdf.format(Date())
        return currentDate.toString()
    }

    fun isItSameDay(date1: String, date2: String): Boolean {

        val firstDate = sdf.parse(date1)
        val secondDate = sdf.parse(date2)

        val compare = firstDate!!.compareTo(secondDate)

        return !(compare > 0 || compare < 0)
    }
}