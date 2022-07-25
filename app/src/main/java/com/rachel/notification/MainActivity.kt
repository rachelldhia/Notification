package com.rachel.notification

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)

        btnSend1.setOnClickListener {
            val title: String = etTitle.text.toString()
            val message = etMessage.text.toString()
            val builder = NotificationCompat.Builder(this, BaseApp.CHANNEL_1_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)


            val notification = builder.build()
            notificationManager.notify(1, notification)

        }
        btnSend2.setOnClickListener {
            val title: String = etTitle.text.toString()
            val message = etMessage.text.toString()
            val builder = NotificationCompat.Builder(this, BaseApp.CHANNEL_2_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_LOW)


            val notification = builder.build()
            notificationManager.notify(2, notification)


        }
    }
}
