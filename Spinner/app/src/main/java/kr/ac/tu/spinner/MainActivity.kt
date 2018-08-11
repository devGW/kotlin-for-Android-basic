package kr.ac.tu.spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1 = arrayListOf<String>("스피너 1-1", "스피너 1-2", "스피너 1-3", "스피너1-4", "스피너1-5")
    var data2 = arrayListOf<String>("스피너 2-1", "스피너 2-2", "스피너 2-3", "스피너2-4", "스피너2-5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter1 = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,data1)
        var adapter2  = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, data2)
//        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
//        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)

        spinner1.adapter = adapter1
        spinner2.adapter = adapter2

//        spinner1.onItemSelectedListener = SpinnerListener()
//        spinner2.onItemSelectedListener = SpinnerListener()
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textView.text = "${data1[p2]} 익명클래스"
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textView.text = "${data2[p2]} 익명클래스"
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }
    inner class SpinnerListener : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            //리스트가 선택 되었을때 이벤트
            if(p0?.id == spinner1.id){
                textView.text = data1[p2]
            } else if(p0?.id == spinner2.id) {
                textView.text = data2[p2]
            } else {
                textView.text = "NULL or Not Selected"
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
            //리스트가 선택되지 않았을때 이벤트
        }
    }

}
