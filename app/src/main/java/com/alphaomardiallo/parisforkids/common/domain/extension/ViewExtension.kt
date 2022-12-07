package com.alphaomardiallo.parisforkids.common.domain.extension

import android.view.View

inline fun View.onClick(
    crossinline onClick: () -> Unit
) = setOnClickListener { onClick() }

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}