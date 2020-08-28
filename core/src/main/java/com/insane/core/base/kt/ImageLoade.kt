package com.insane.core.base.kt

import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.load
import coil.loadAny
import coil.transform.CircleCropTransformation
import com.insane.core.R
import java.io.File

/**
 *Created by Insane
 */
//加载网络图片
fun ImageView.loadImageUrl(url: String, @DrawableRes drawableResId: Int) {
    this.load(url) {
        crossfade(true)
        placeholder(drawableResId)
    }
}

fun ImageView.loadImageUrl(url: String) {
    this.loadImageUrl(url, R.drawable.ic_launcher)
}

//加载文件
fun ImageView.loadImageFile(file: File, @DrawableRes drawableResId: Int) {
    this.load(file) {
        crossfade(true)
        placeholder(drawableResId)
    }
}

fun ImageView.loadImageFile(file: File) {
    this.loadImageFile(file, R.drawable.ic_launcher)
}

//加载本地drawable
fun ImageView.loadImageDrawable(@DrawableRes drawableResId: Int, @DrawableRes placeholder: Int) {
    this.load(drawableResId) {
        crossfade(true)
        placeholder(placeholder)
    }
}

fun ImageView.loadImageDrawable(@DrawableRes drawableResId: Int) {
    this.loadImageDrawable(drawableResId, R.drawable.ic_launcher)
}

//自己判断类型
fun ImageView.loadImageAny(any: Any, @DrawableRes drawableResId: Int) {
    this.loadAny(any) {
        crossfade(true)
        placeholder(drawableResId)
    }
}

fun ImageView.loadImageAny(any: Any) {
    this.loadImageAny(any, R.drawable.ic_launcher)
}

//圆角
fun ImageView.loadCircleImage(any: Any, @DrawableRes drawableResId: Int) {
    this.loadAny(any) {
        crossfade(true)
        placeholder(drawableResId)
        transformations(CircleCropTransformation())
    }
}

fun ImageView.loadCircleImage(any: Any) {
    this.loadCircleImage(any, R.drawable.ic_launcher)
}

