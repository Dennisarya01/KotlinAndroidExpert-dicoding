package com.dicoding.footballapps.util

import android.content.res.Resources
import com.bumptech.glide.load.engine.Resource

val Int.dip : Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()
val Int.pixel : Int get() = (this / Resources.getSystem().displayMetrics.density).toInt()