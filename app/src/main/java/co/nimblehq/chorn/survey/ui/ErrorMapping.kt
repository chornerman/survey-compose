package co.nimblehq.chorn.survey.ui

import android.content.Context
import co.nimblehq.chorn.survey.R
import co.nimblehq.chorn.survey.domain.exceptions.ApiException

fun Throwable.userReadableMessage(context: Context): String {
    return when (this) {
        is ApiException -> error?.message
        else -> message
    } ?: context.getString(R.string.error_generic)
}
