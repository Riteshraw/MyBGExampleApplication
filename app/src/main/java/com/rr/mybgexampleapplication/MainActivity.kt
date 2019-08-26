package com.rr.mybgexampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager = WorkManager.getInstance(application)

        // Create a Constraints object that defines when the task should run
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            //.setRequiresDeviceIdle(true)
            //.setRequiresCharging(true)
            .build()

        // ...then create a OneTimeWorkRequest that uses those constraints
//        val compressionWork = OneTimeWorkRequestBuilder<ConnectivityWorker>()
//            .setConstraints(constraints)
//            .build()

        workManager.enqueue(OneTimeWorkRequest.from(ConnectivityWorker::class.java))
    }
}
