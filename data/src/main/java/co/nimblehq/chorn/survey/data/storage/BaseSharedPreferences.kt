package co.nimblehq.chorn.survey.data.storage

import android.content.SharedPreferences

const val ACCESS_TOKEN_PREFERENCES_KEY = "ACCESS_TOKEN"
const val REFRESH_TOKEN_PREFERENCES_KEY = "REFRESH_TOKEN"
const val TOKEN_TYPE_PREFERENCES_KEY = "TOKEN_TYPE"

abstract class BaseSharedPreferences {

    lateinit var sharedPreferences: SharedPreferences

    inline fun <reified T> get(key: String): T? =
        if (sharedPreferences.contains(key)) {
            when (T::class) {
                Boolean::class -> sharedPreferences.getBoolean(key, false) as T?
                String::class -> sharedPreferences.getString(key, null) as T?
                Float::class -> sharedPreferences.getFloat(key, 0f) as T?
                Int::class -> sharedPreferences.getInt(key, 0) as T?
                Long::class -> sharedPreferences.getLong(key, 0L) as T?
                else -> null
            }
        } else {
            null
        }

    fun <T> set(key: String, value: T) {
        sharedPreferences.execute {
            when (value) {
                is Boolean -> it.putBoolean(key, value)
                is String -> it.putString(key, value)
                is Float -> it.putFloat(key, value)
                is Long -> it.putLong(key, value)
                is Int -> it.putInt(key, value)
            }
        }
    }

    protected fun remove(key: String) {
        sharedPreferences.execute { it.remove(key) }
    }

    protected fun clearAll() {
        sharedPreferences.execute { it.clear() }
    }
}
