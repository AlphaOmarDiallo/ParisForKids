package com.alphaomardiallo.parisforkids.common.domain.util.date

interface DateUtil {

    fun createDate(): String

    fun isItSameDay(date1: String, date2: String): Boolean
}