package com.muehlemann.base.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import dagger.hilt.android.qualifiers.ApplicationContext

class Preferences(@ApplicationContext context: Context) {

  private val preferences = context.getSharedPreferences("preferences", MODE_PRIVATE)

  var apiKey: String?
    get() = preferences.getString(API_KEY, null)
    set(value) = preferences.edit().putString(API_KEY, value).apply()

  companion object {
    const val API_KEY = "API_KEY"
  }
}