package com.github.mikemedina

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.github.mikemedina.swipe_image_viewer.R

class ImagePagerAdapter(private val activity: MainActivity) : PagerAdapter() {

    // TODO: Dynamically fetch the next page of images
    private val images = DownloadImageTask().execute().get()
    private var index = 0

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val padding = activity.resources.getDimensionPixelSize(R.dimen.padding_medium)
        val imageView = ImageView(activity)

        imageView.setPadding(padding, padding, padding, padding)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        container.addView(imageView, 0)

        imageView.setImageBitmap(images[index++])

        return imageView
    }

    override fun getItemPosition(`object`: Any?): Int = images.indexOf(`object`)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }

    override fun getCount(): Int = 26

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`

}
