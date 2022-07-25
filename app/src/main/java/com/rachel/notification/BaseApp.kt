package com.rachel.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class BaseApp : Application() {

    companion object {
        const val CHANNEL_1_ID = " channel1"
        const val CHANNEL_2_ID = "channel2"

    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1 = NotificationChannel(
                CHANNEL_1_ID,
                "Channel One",
                NotificationManager.IMPORTANCE_HIGH
            )
            val channel2 = NotificationChannel(
                CHANNEL_2_ID,
                "Channel Two",
                NotificationManager.IMPORTANCE_LOW
            )
            channel1.description = "This Channel 1"

            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel1)
            manager?.createNotificationChannel(channel2)

        }
    }
}