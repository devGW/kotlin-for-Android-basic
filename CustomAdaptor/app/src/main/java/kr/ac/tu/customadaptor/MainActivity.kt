package kr.ac.tu.customadaptor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("data1","data2","data3","data4","data5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // var adapter = ArrayAdapter<String>(this, R.layout.row, R.id.rowText, data)
        var adapter = ListAdapter()
        mainListView.adapter =adapter

    }

    inner class ListAdapter : BaseAdapter(){
        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
            var convertView:View? = p1 // p1 은 list 를 스크롤 할때 사라젔다가 다시 보이는 경우 재활용을 위해 p1 에 사라진 항목 저장
            // 기존에 없었고 새로 생긴 항목들이 들어오면 null
            if(p1 == null){
                convertView = layoutInflater.inflate(R.layout.row,null)
            }

            var textView = convertView?.findViewById<TextView>(R.id.rowText)
            var btn1 = convertView?.findViewById<Button>(R.id.btn1)
            var btn2 = convertView?.findViewById<Button>(R.id.btn2)
            textView?.text = data[p0]
            btn1?.setOnClickListener(BtnListener())
            btn2?.setOnClickListener(BtnListener())
            return convertView
        }

        inner class BtnListener : View.OnClickListener{
            override fun onClick(p0: View?) {
                var position:Int? = p0?.tag as Int
                when(p0?.id){
                    R.id.btn1 -> mainTextView.text = "${position} 번째 btn1 입니다"
                    R.id.btn2 -> mainTextView.text = "${position} 번째 btn2 입니다"
                }
            }
        }
    }
}
