package com.github.mikemedina

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL

class DownloadImageTask(private val imageView: ImageView, private val index: Int) : AsyncTask<Any, Void, Bitmap>() {

    override fun doInBackground(vararg unused: Any): Bitmap {
        val imageUrls = RedditApiWrapper().getPictureUrls()
        val url = URL(imageUrls[index])
        val connection = url.openConnection() as HttpURLConnection
        val inputStream = connection.inputStream
        return BitmapFactory.decodeStream(inputStream)
    }

    override fun onPostExecute(result: Bitmap?) {
        imageView.setImageBitmap(result)
    }

}
