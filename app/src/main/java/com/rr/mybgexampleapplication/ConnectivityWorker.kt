package com.rr.mybgexampleapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.work.Worker
import androidx.work.WorkerParameters

class ConnectivityWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    val appContxt = applicationContext

    override fun doWork(): Result {
        //makeStatusNotification("Blurring image", appContext)
        //Check network connectivity
        return if (isConnectedToInternet())
            Result.success()
        else
            Result.failure()
    }

    private fun isConnectedToInternet(): Boolean {
        val cm = appContxt.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        val isWiFi: Boolean = activeNetwork?.type == ConnectivityManager.TYPE_WIFI

        return isConnected
    }
}