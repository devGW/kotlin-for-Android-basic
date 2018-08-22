package com.example.doscm.nofitication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            var builder = getNotificationBuilder("pending", "pending intent")
            builder.setContentTitle("notifiation 1")
            builder.setContentText("알림 메시지 1입니다")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            builder.setAutoCancel(true)

            var intent1 = Intent(this, TestActivity1::class.java)
            var pending1 = PendingIntent.getActivity(this, 10, intent1, 0)
            builder.setContentIntent(pending1)

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

    }
    fun getNotificationBuilder(id: String, name: String): NotificationCompat.Builder {
        var builder: NotificationCompat.Builder? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableLights(true)
            manager.createNotificationChannel(channel)
            builder = NotificationCompat.Builder(this, id)
        } else {
            builder = NotificationCompat.Builder(this)
        }
        return builder
    }
}
