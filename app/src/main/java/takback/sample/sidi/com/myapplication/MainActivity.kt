package takback.sample.sidi.com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    companion object {
        val TAG = "WebView"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView = findViewById<WebView>(R.id.webView)
        val actionButton = findViewById<FloatingActionButton>(R.id.action_button)

        actionButton.setOnClickListener {
            loadGoogleWebSite(webView)
        }

        setupWebView(webView)

        webView?.loadUrl("file:///android_asset/autoplay.html")
    }

    private fun setupWebView(webView: WebView) {
        webView.webViewClient = WebViewClient()

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.allowUniversalAccessFromFileURLs = true
        webSettings.loadsImagesAutomatically = true
        webSettings.useWideViewPort = true
        webSettings.allowFileAccessFromFileURLs = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webSettings.loadWithOverviewMode = true
        webSettings.mediaPlaybackRequiresUserGesture = false

        Log.d(TAG, "UniversalFileAccess: " + webView.settings.allowUniversalAccessFromFileURLs)

    }

    private fun loadGoogleWebSite(webView: WebView) {
        webView.loadUrl("https://www.google.com")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack()
        else super.onBackPressed()
    }
}
