package kr.ac.tu.popupmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            var pop = PopupMenu(this, tV1)
            menuInflater.inflate(R.menu.popup_menu, pop.menu)
            // pop.setOnMenuItemClickListener(PopupListener())// 방법 1
            pop.setOnMenuItemClickListener {
                when (it?.itemId) {
                    R.id.item1 -> tV1.text = "람다식 1번"
                    R.id.item2 -> tV1.text = "람다식 2번"
                    R.id.item3 -> tV1.text = "람다식 3번"
                }

                false
            }
            pop.show()
        }
    }

    inner class PopupListener : PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(p0: MenuItem?): Boolean {
            when (p0?.itemId) {
                R.id.item1 -> tV1.text = "1번 아이템"
                R.id.item2 -> tV1.text = "2번 아이템"
                R.id.item3 -> tV1.text = "3번 아이템"
            }
            return false
        }
    }
}
