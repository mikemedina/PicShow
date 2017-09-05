package com.github.mikemedina

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL

class DownloadImageTask(private val img: ImageView?, private val index: Int) : AsyncTask<Any, Void, Bitmap>() {

    private val imageUrls = mutableListOf<String>()

    override fun doInBackground(vararg unused: Any): Bitmap? {
        if (imageUrls.isEmpty()) {
            imageUrls.addAll(RedditApiWrapper().getPictureUrls())
        }

        val url = URL(imageUrls[index])
        val connection = url.openConnection() as HttpURLConnection
        val inputStream = connection.inputStream

        return BitmapFactory.decodeStream(inputStream)
    }

    override fun onPostExecute(image: Bitmap?) {
        img?.setImageBitmap(image)
    }

}
