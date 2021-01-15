package com.example.e_softwarica.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.e_softwarica.R


class AboutusFragment : Fragment() {
private lateinit var webview:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_aboutus, container, false)
        webview= view.findViewById(R.id.webview)
        webview.setWebViewClient(WebViewClient())
        webview.loadUrl("https://softwarica.edu.np/")
        webview.settings.javaScriptEnabled=true;


        return view
    }


}