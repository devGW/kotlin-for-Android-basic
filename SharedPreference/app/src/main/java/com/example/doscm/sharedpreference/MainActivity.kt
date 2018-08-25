package com.example.doscm.sharedpreference

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        //SharedPreference 객체 생성

        var edit = sharedPreference.edit()
        //SharedPreference 수정 객체

        var saveString = sharedPreference.getString("userID", "ID 를 입력해 주세요")
        editTextEmail.setText(saveString)

        buttonSave.setOnClickListener {
            edit.putString("userID",editTextEmail.text.toString()).commit()
        }
    }
}
