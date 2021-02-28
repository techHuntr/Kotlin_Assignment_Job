package com.jobs.assignment.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


fun Context.displayToast(message:String?){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

inline fun View.snack(message: String?, messageRes: Int, length: Int = Snackbar.LENGTH_LONG, color: Int? = null, colorBackground: Int? = null, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message!!, length)
    val snackBarView: View = snack.view
    snack.f()
    snack.show()
    color?.let {
        snack.setActionTextColor(ContextCompat.getColor(context, color))
        snackBarView.setBackgroundColor(ContextCompat.getColor(context,colorBackground!!));
    }
}

inline fun Activity.snack(message: String?, messageRes: Int, length: Int = Snackbar.LENGTH_LONG, color: Int? = null, colorBackground: Int? = null, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(window.decorView, message!!, length)
    val snackBarView: View = snack.view
    snack.f()
    snack.show()
    color?.let {
        snack.setActionTextColor(ContextCompat.getColor(this, color))
        snackBarView.setBackgroundColor(ContextCompat.getColor(this,colorBackground!!));
    }
}