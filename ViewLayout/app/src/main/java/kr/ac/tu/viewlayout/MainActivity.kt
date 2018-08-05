package kr.ac.tu.viewlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var btn : Button? = null
        var tV : TextView? = null
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button)
        tV = findViewById(R.id.textview)
       /* btn.setOnClickListener({
            tV?.setText("성유진")
        })*/

        button.setOnClickListener {
            if(textview.getText() == "정건우"){
                textview.setText("성유진")
            } else {
                textview.setText("정건우")
            }
        }
    }
}
