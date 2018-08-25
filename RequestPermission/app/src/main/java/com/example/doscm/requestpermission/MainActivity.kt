package com.example.doscm.requestpermission

import android.Manifest
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calender = android.Manifest.permission.READ_CALENDAR
        var camera = android.Manifest.permission.CAMERA
        var contact = android.Manifest.permission.READ_CONTACTS

        var location = Manifest.permission.ACCESS_FINE_LOCATION
        var microphone = Manifest.permission.RECORD_AUDIO
        var phone = Manifest.permission.READ_PHONE_STATE

        var sensor = Manifest.permission.BODY_SENSORS
        var sms = Manifest.permission.SEND_SMS
        var storage = Manifest.permission.READ_EXTERNAL_STORAGE

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(calender, camera, contact, location, microphone, phone, sensor, sms, storage), 0)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0) {
            for (i in permissions.indices) {
                println("권한 : ${permissions[i]} 허용 : ${grantResults[i]}")
            }
        }
    }
}
