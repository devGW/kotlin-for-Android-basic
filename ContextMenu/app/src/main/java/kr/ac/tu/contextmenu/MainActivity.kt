package kr.ac.tu.contextmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("data1", "data2", "data3", "data4", "data5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            textView.text = "${i}번째 리스트 클릭"
        }

        registerForContextMenu(textView)
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) { // 사용자가 길게 누른 view 객체가 넘오옴.
            textView.id -> {
                menu?.setHeaderTitle("텍스트뷰의 메뉴")
                menuInflater.inflate(R.menu.text_menu, menu)
            }
            listView.id -> {
                menu?.setHeaderTitle("리스트뷰의 메뉴")
                menuInflater.inflate(R.menu.text_menu, menu)
                var info = menuInfo as AdapterView.AdapterContextMenuInfo
                if (info.position % 2 == 0){
                    menu?.add(Menu.NONE, Menu.FIRST+1,Menu.NONE, "리스트 뷰 메뉴")
                }
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item1 -> textView.text = "1번째 클릭"
            R.id.item2 -> {
                var info =  item?.menuInfo as AdapterView.AdapterContextMenuInfo
                textView.text = "2번째 클릭 ${info.position} 번째 리스트"
            }
            Menu.FIRST + 1 -> textView.text = "코드메뉴 이벤트"
        }
        return super.onContextItemSelected(item)
    }
}
