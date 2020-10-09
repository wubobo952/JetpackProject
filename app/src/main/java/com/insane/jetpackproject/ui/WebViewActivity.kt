package com.insane.jetpackproject.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import com.insane.core.base.utils.BaseConfig
import com.insane.core.base.view.BaseActivity
import com.insane.jetpackproject.R
import com.insane.jetpackproject.utils.JianShuWebClient
import com.insane.jetpackproject.utils.JueJinWebClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : BaseActivity() {

    private var url: String? = null
    override fun getLayout() = R.layout.activity_web_view

    override fun initView() {
        val intent = intent
        url = intent.getStringExtra(BaseConfig.PARAMETER)
        setWebViewSettings()
        vWebView.webViewClient = JueJinWebClient()
//            object : WebViewClient() {
//            override fun onPageFinished(view: WebView, url: String) {
//                super.onPageFinished(view, url)
//                hideTitle(view, url)
//            }
//
//            override fun shouldOverrideUrlLoading(wv: WebView, url: String?): Boolean {
//                if (url == null) return false
//                try {
//                    if (isAdDomain(url)) {
//                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
//                        return true
//                    }
//                } catch (e: Exception) {
//                    return true
//                }
//                wv.loadUrl(url)
//                return true
//            }
//        }
        vWebView.loadUrl(url)

    }


    @SuppressLint("SetJavaScriptEnabled")
    fun setWebViewSettings() {
        vWebView.settings
            .apply {
                loadWithOverviewMode = true
                useWideViewPort = true
                javaScriptEnabled = true
                domStorageEnabled = true
                //禁止缩放
                displayZoomControls = false
                builtInZoomControls = false
                //禁止文字缩放
                textZoom = 60
                //允许file协议
                allowFileAccess = true
                //自动加载图片
                loadsImagesAutomatically = true
            }
    }

    fun isAdDomain(url: String): Boolean {
        return (url.contains("jianshu"))
    }

    private fun hideTitle(view: WebView, url: String) {
        var javascript: String? = null

        if (url.contains("jianshu")) {
            javascript = ("javascript:function hideTitle() {"
                    + "document.getElementsByClassName('header-wrap')[0].style.display='none';"
                    + "document.getElementsByClassName('call-app-btn')[0].style.display='none';"
                    + "}")
        } else if (url.contains("juejin")) {
            javascript = ("javascript:function hideTitle() {"
                    + "document.getElementsByClassName('main-header-box')[0].style.display='none';"
                    + "document.getElementsByClassName('action-box action-bar')[0].style.display='none';"
                    + "}")
        }
        //加载方法
        javascript?.let {
            view.loadUrl(it)
            //执行方法
            view.loadUrl("javascript:hideTitle();")
        }

    }
}