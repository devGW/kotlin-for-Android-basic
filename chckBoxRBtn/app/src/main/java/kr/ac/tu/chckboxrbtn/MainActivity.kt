package kr.ac.tu.chckboxrbtn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            chckBox1.isChecked = true
            chckBox2.isChecked = true
            chckBox3.isChecked = true
        }
        button2.setOnClickListener {
            chckBox1.toggle()
            chckBox2.toggle()
            chckBox3.toggle()
        }
        button3.setOnClickListener {
            when (group.checkedRadioButtonId) {
                rbtn1.id -> textview.text = "1번째 라디오 버튼"
                rbtn2.id -> textview.text = "2번째 라디오 버튼"
                rbtn3.id -> textview.text = "3번째 라디오 버튼"

            }
        }
        chckBox1.setOnCheckedChangeListener { compoundButton, b ->
            if (b == true) {
                textview.text = "체크 버튼 1 클릭 이벤트"
            }
        }

        chckBox2.setOnCheckedChangeListener(Listener())

    }

    inner class Listener : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            if(p0 == chckBox2){
                textview.text = "inner class event"
            }
        }
    }
}
