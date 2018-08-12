package kr.ac.tu.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var viewList = ArrayList<View>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewList.add(layoutInflater.inflate(R.layout.view1, null))
        viewList.add(layoutInflater.inflate(R.layout.view2, null))

        pager.adapter = CustomAdapter()
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
                //페이지의 상태 변화 갯수 p0
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                //현재페이지의 인덱스 p0
                textView.text = "${p0} 번째 페이지"
            }

            override fun onPageSelected(p0: Int) {
                //이동한 페이지의 인덱스 p0
            }
        })
    }

    inner class CustomAdapter : PagerAdapter() {
        override fun getCount(): Int {
            return viewList.size
        }

        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0 == p1
            //보여주고자 하는 화면과 불러온 화면이 서로 일치하는지 검사
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            pager.addView(viewList[position])
            return viewList[position]
            // isViewFromObject 에 p0 에 addView 한게 넘어가고
            // p1 에 return 한 값이 넘어가서 비교함
        }

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            pager.removeView(obj as View)
            // 화면이 넘어갈때 안보이는 화면을 삭제
            // obj 로 넘어오는데 View 로 형변환 하여 삭제
        }
    }
}
