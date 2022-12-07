package com.alphaomardiallo.parisforkids.common.domain.util.date

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateUtilImp @Inject constructor() : DateUtil {
    private val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE)

    override fun createDate(): String {
        val currentDate = sdf.format(Date())
        return currentDate.toString()
    }

    override fun isItSameDay(date1: String, date2: String): Boolean {

        val firstDate = sdf.parse(date1)
        val secondDate = sdf.parse(date2)

        val compare = firstDate!!.compareTo(secondDate)

        return !(compare > 0 || compare < 0)
    }
}