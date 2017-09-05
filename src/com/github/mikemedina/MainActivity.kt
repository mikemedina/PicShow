package com.github.mikemedina

import android.app.Activity
import android.os.Bundle
import com.github.mikemedina.swipe_image_viewer.R
import kotlinx.android.synthetic.main.activity_main.view_pager

class MainActivity : Activity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view_pager.adapter = ImagePagerAdapter(this)
        view_pager.offscreenPageLimit = 30
    }

}
