package com.alphaomardiallo.parisforkids.common.domain.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

inline fun <T> LiveData<T>.subscribe(
    owner: LifecycleOwner,
    crossinline onDataReceived: (T) -> Unit
) = observe(owner) { onDataReceived(it) }

fun <T> LiveData<T>.unsubscribe(
    owner: LifecycleOwner
) = removeObservers(owner)