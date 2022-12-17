package com.alphaomardiallo.parisforkids.common.domain.util.snackBar

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun createSnackBar(
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    messageDisplayed: String,
    actionLabelDisplayed: String? = null,
    durationLong: Boolean = false,
    durationIndefinite: Boolean = false
): SnackbarResult? {
    var snackBarResult: SnackbarResult? = null

    coroutineScope.launch {
        snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
            message = messageDisplayed,
            actionLabel = if (actionLabelDisplayed.isNullOrBlank()) null else actionLabelDisplayed,
            duration = if (durationIndefinite) {
                SnackbarDuration.Indefinite
            } else {
                if (durationLong) SnackbarDuration.Long else SnackbarDuration.Short
            }
        )

    }
    return snackBarResult
}