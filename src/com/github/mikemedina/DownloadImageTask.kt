package com.github.mikemedina

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import java.net.HttpURLConnection
import java.net.URL

class DownloadImageTask : AsyncTask<Any, Void, List<Bitmap>>() {

    override fun doInBackground(vararg unused: Any): List<Bitmap> {
        val imageUrls = RedditApiWrapper().getPictureUrls()
        return imageUrls.mapNotNull {
            val url = URL(it)
            val connection = url.openConnection() as HttpURLConnection
            val inputStream = connection.inputStream
            BitmapFactory.decodeStream(inputStream)
        }
    }

}
