package com.insane.jetpackproject.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat.startActivity
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.util.regex.Pattern

/**
 *Created by Insane
 */
class JianShuWebClient constructor(private var context: Context) : WebViewClient() {

    override fun shouldInterceptRequest(view: WebView?, url: String?)
            : WebResourceResponse? {
        val urlStr = url ?: ""
        if (urlStr.startsWith("https://www.jianshu.com/p/")) {
            val response = Wget.get(url ?: "")
            val res = darkBody(replaceCss(response, view!!.context))
            val input = ByteArrayInputStream(res.toByteArray())
            return WebResourceResponse("text/html", "utf-8", input)
        }
        return super.shouldInterceptRequest(view, url)
    }

    override fun shouldOverrideUrlLoading(wv: WebView, url: String?): Boolean {
        if (url == null) return false
        try {
            if (isAdDomain(url)) {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                return true
            }
        } catch (e: Exception) {
            return true
        }
        wv.loadUrl(url)
        return true
    }

    override fun onPageFinished(view: WebView, url: String) {
        hideTitle(view,url)
        super.onPageFinished(view, url)
    }


    private val rex = "(<style data-vue-ssr-id=[\\s\\S]*?>)([\\s\\S]*]?)(<\\/style>)"
    private val bodyRex = "<body class=\"([\\ss\\S]*?)\""
    private fun darkBody(res: String): String {
        val pattern = Pattern.compile(bodyRex)
        val m = pattern.matcher(res)
        return if (m.find()) {
            val s = "<body class=\"reader-night-mode normal-size\""
            res.replace(bodyRex.toRegex(), s)
        } else res
    }

    private fun replaceCss(res: String, context: Context): String {
        val pattern = Pattern.compile(rex)
        val m = pattern.matcher(res)
        return if (m.find()) {
            val css = getString(context.assets.open("jianshu/jianshu.css"))
            val sb = StringBuilder()
            sb.append(m.group(1))
            sb.append(css)
            sb.append(m.group(3))
            val res = res.replace(rex.toRegex(), sb.toString())
            Log.e("test", "$res")
            res
        } else {
            res
        }
    }

    private fun getString(stream: InputStream): String {
        val reader = BufferedReader(InputStreamReader(stream, "utf-8"))
        val sb = StringBuilder()
        var s: String? = reader.readLine()
        while (s != null) {
            sb.append(s).append("\n")
            s = reader.readLine()
        }
        return sb.toString()
    }

    private fun isAdDomain(url: String): Boolean {
        return (url.contains("jianshu"))
    }

    private fun hideTitle(view: WebView, url: String) {
        var javascript: String? = null

        if (url.contains("juejin")) {
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
