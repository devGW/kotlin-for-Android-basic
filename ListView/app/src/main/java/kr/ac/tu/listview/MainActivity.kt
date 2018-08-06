package kr.ac.tu.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    var imgRes = intArrayOf(R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4, R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8)
    var data1 = arrayOf("토고", "스위스", "프랑스", "스페인", "일본", "독일", "브라질", "대한민국")
    var data2 = arrayOf("togo", "swiss", "france", "spain", "japan", "german", "brazil", "korea")
    //listView 이미지. textView 2줄
    var list = arrayOf("리스트1", "리스트2", "리스트3", "리스트4", "리스트5") // ListView 기초 data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ListView 이용을 위해 adapter 객체를 생성
        // AppCompatActivity 밑이라면 context 는 this
        //var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list) //매개변수 어떠한정보를 , 어떠한 모양으로 , 몇개를
        // var adapter = ArrayAdapter(this, R.layout.row1, R.id.textView2, list) // 내가 만든 layout 으로 list 설정
        //listView.adapter = adapter

        //listView.setOnItemClickListener(ListListener())
        //listView.setOnItemClickListener { adapterView, view, i, l ->
        //    textView.text = list[i]

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        var hashList = ArrayList<HashMap<String, Any>>()
        var idx = 0
        while (idx < data1.size) {
            var map = HashMap<String, Any>()

            map.put("flag", imgRes[idx])
            map.put("data1", data1[idx])
            map.put("data2", data2[idx])
            hashList.add(map)
            idx++
            Log.d("asdf","${idx}")
        }
        var keys = arrayOf("flag", "data1", "data2")
        var ids = intArrayOf(R.id.imgView, R.id.textView2, R.id.textView3)
        var adapter2 = SimpleAdapter(this, hashList, R.layout.row2, keys, ids)
        listView.adapter = adapter2
    }

}

/* inner class ListListener : AdapterView.OnItemClickListener {
     override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) { // p2 부분이 사용자가 클릭한 리스트의 인덱스 번호
         textView.text = list[p2]
     }
 }*/


