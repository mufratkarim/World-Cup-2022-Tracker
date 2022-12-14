package com.mka.fifa.world.cup2022.encyclopedia.presentation.players

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import androidx.compose.ui.viewinterop.AndroidView
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun PlayersScreen() {
    val url = Constants.WEBVIEW_URL
    var backEnabled by remember { mutableStateOf(false) }
    var webView: WebView? = null
    AndroidView(factory = { context ->
        WebView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.loadsImagesAutomatically = true
            settings.javaScriptEnabled = true
            settings.builtInZoomControls = true
            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    if (view != null) {
                        backEnabled = view.canGoBack()
                    }
                }
            }
            loadUrl(url)
            webView = this
        }
    }, update = {
        webView = it
    })
    BackHandler(enabled = backEnabled) {
        webView?.goBack()
    }
}