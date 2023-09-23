package com.muehlemann.base.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun Long.toDate(pattern: String): String {
  return SimpleDateFormat(pattern, Locale.ENGLISH).format(this * 1000L)
}

fun Long.toTime(pattern: String): String {
  return SimpleDateFormat(pattern, Locale.ENGLISH).format(this * 1000L)
}