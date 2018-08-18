package com.example.doscm.daialog

import android.app.TimePickerDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.EditText
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.daialog.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listener = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when (which) {
                    DialogInterface.BUTTON_POSITIVE ->
                        tV1.text = "Positive : 취소"
                    DialogInterface.BUTTON_NEGATIVE ->
                        tV1.text = "Nagative : 확인"
                }
            }
        }
        button1.setOnClickListener {
            var dialog = AlertDialog.Builder(this)
            dialog.setTitle("제목")
            dialog.setMessage("본문")
            dialog.setIcon(R.mipmap.ic_launcher)
            dialog.setPositiveButton("취소", listener)
            dialog.setNegativeButton("확인", listener)
            dialog.show()
        }




        var listener2 = object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                var alert = dialog as AlertDialog
                var edit1 = alert.findViewById<EditText>(R.id.eT1)
                var edit2 = alert.eT1

                tV1.text = "edit1 :${edit1?.text}\n"
                tV1.append("edit2 : ${edit2?.text}")

            }
        }
        button2.setOnClickListener {
            var dialog = AlertDialog.Builder(this)
            dialog.setTitle("제목")
            dialog.setMessage("내용")
            dialog.setPositiveButton("확인",listener2)
            dialog.setNegativeButton("취소",null)
            dialog.setView(R.layout.daialog)
            dialog.show()
        }
        button3.setOnClickListener{
            var hour = Calendar.HOUR
            var min = Calendar.MINUTE

            var listener = object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    tV1.text = "${hourOfDay}시 ${minute}분"
                }
            }
            var picker = TimePickerDialog(this,listener,hour,min,true)
            picker.show()
        }
    }
}
