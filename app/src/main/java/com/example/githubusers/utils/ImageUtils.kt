package com.example.githubusers.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.BufferedInputStream
import java.io.IOException
import java.net.URL
import java.net.URLConnection


class ImageUtils {
  companion object {
    fun getRemoteImage(url: String?): Bitmap? {
      return try {
        val conn: URLConnection = URL(url).openConnection()
        conn.connect()
        val bis = BufferedInputStream(conn.getInputStream())
        val bm = BitmapFactory.decodeStream(bis)
        bis.close()
        bm
      } catch (e: IOException) {
        null
      }
    }
  }
}