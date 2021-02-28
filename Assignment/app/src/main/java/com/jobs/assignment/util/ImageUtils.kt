package com.jobs.assignment.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.Dp
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.jobs.assignment.R

@Composable
fun loadPicture(url: String, @DrawableRes defaultImage: Int): MutableState<Bitmap?> {

    val bitMapState: MutableState<Bitmap?> = mutableStateOf(null)

    val circularProgressDrawable = CircularProgressDrawable(AmbientContext.current)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()

    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitMapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })

    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(circularProgressDrawable)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitMapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })


    return bitMapState
}

@Composable
fun loadPicture(@DrawableRes drawable: Int): MutableState<Bitmap?> {

    val bitMapState: MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(drawable)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitMapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })
    return bitMapState
}

@Composable
fun Img() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val img = imageResource(id = R.drawable.empty_image)
        val modifier = Modifier
            .fillMaxWidth()
            .preferredHeight(height = Dp(200F))
        Image(
            img,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}