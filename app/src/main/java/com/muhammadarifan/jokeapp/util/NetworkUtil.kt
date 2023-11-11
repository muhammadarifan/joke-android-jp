package com.muhammadarifan.jokeapp.util

import android.content.Context
import android.net.NetworkCapabilities

object NetworkUtil {
    fun isNetworkConnected(context: Context): Boolean {
        var haveConnectedWifi = false
        var haveConnectedMobile = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as android.net.ConnectivityManager
        val netInfo = cm.activeNetwork

        if (netInfo != null) {
            val networkCapabilities = cm.getNetworkCapabilities(netInfo)
            if (networkCapabilities != null) {
                if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    haveConnectedWifi = true
                }
                if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    haveConnectedMobile = true
                }
            }
        }

        return haveConnectedWifi || haveConnectedMobile
    }
}