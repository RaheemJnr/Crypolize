package com.raheemjnr.cryptolize.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun showLongToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).apply { show() }

}

fun showShortToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).apply { show() }
}


/**
 * Open given [url] to a browser.
 */
fun Context.openUrl(url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        showLongToast(this, "Cannot open the link!")
    }
}
