package com.example.doscm.listdialog

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var data = arrayOf("data1", "data2", "data3", "data4", "data5")
    var data2 = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국")
    var data3 = intArrayOf(R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3,
            R.drawable.imgflag4, R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7,
            R.drawable.imgflag8)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("제목")
            builder.setNegativeButton("확인", null)
            builder.setPositiveButton("취소", null)
            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    tV1.text = "List Dialog ${data[which]}"
                }
            }
            builder.setItems(data, listener)
            builder.show()
        }
        btn2.setOnClickListener {

            var builder = AlertDialog.Builder(this)
            builder.setTitle("국가")
            builder.setPositiveButton("취소", null)

            var list = ArrayList<HashMap<String, Any?>>()
            for (i in data2.indices) {
                var map = HashMap<String, Any?>()
                map.put("data2", data2[i])
                map.put("data3", data3[i])
                list.add(map)
            }
            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    tV1.text = "선택한 국가 : ${data2[which]}"
                }
            }
            var key = arrayOf("data2", "data3")
            var id = intArrayOf(R.id.textView, R.id.imageView)
            var adapter = SimpleAdapter(this, list, R.layout.custom_dialog, key, id)
            builder.setAdapter(adapter,listener)
            builder.show()
        }
    }
}
