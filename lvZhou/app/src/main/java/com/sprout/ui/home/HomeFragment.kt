package com.sprout.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.sprout.R
import com.sprout.base.BaseFragment
import com.sprout.databinding.LayoutHomefragBinding
import com.sprout.ui.home.tj.TJFrag
import com.sprout.viewmodel.home.HomeViewModel
import kotlinx.android.synthetic.main.layout_homefrag.*


class HomeFragment:BaseFragment<HomeViewModel,LayoutHomefragBinding>(R.layout.layout_homefrag,HomeViewModel::class.java) {
    lateinit var tcFrag:Fragment
    lateinit var gzFrag:Fragment
    lateinit var tjFrag:Fragment

    val fraglist = ArrayList<Fragment>()
    val name = ArrayList<String>()

    //未选中的Tab图片
    private val unSelectTabRes = intArrayOf(
        R.drawable.tab_nearby
        , R.drawable.tab_follow, R.drawable.tab_recommend
    )

    //选中的Tab图片
    private val selectTabRes = intArrayOf(
        R.drawable.tab_nearby_highlight, R.drawable.tab_follow_highlight
        , R.drawable.tab_recommend_highlight
    )

//    var customParent : CustomView? = null
    companion object{
        val instance by lazy { HomeFragment() }
    }


    override fun initView() {
        fraglist.clear()
        tcFrag = TCFrag()
        gzFrag = GZFrag()
        tjFrag = TJFrag()
        name.add("同城")
        name.add("关注")
        name.add("推荐")
        fraglist.add(tcFrag)
        fraglist.add(gzFrag)
        fraglist.add(tjFrag)


        vp.adapter = vpAdapter(childFragmentManager)
        vp.currentItem = 1
        tab1.setupWithViewPager(vp)

        //初始化：
        for (i in 0 until 3) {
            if (i == 1) {
                tab1.getTabAt(1)!!.setIcon(selectTabRes[1])
            } else {
                tab1.getTabAt(i)!!.setIcon(unSelectTabRes[i])
            }
        }
        initLis()
    }

    private fun initLis() {

        tab1.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                for (i in 0 until 3) {
                    if (tab === tab1.getTabAt(i)) {
                        tab1.getTabAt(i)!!.setIcon(selectTabRes[i])
                        vp.setCurrentItem(i)
                    }
                }

            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

                for (i in 0 until 3) {
                    if (tab === tab1.getTabAt(i)) {
                        tab1.getTabAt(i)!!.setIcon(unSelectTabRes[i])
                    }
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
    //    private fun tab_icon(iconID: Int): View? {
//        val newtab: View = LayoutInflater.from(context).inflate(R.layout.tab_item, null)
//
//        val im: ImageView = newtab.findViewById(R.id.tabicon) as ImageView
//        im.setImageResource(iconID)
//        return newtab
//    }
//    private fun deleteView(k: Int) {
//        val customParent: ViewParent = tab1.getTabAt(k)!!.getCustomView()!!.getParent()
//        if (customParent != null) {
//            (customParent as ViewGroup).removeView(tab1.getTabAt(k)!!.getCustomView())
//        }
//    }

    override fun initVM() {

    }

    override fun initData() {

    }

    override fun initVariable() {

    }

    inner class vpAdapter(fm: FragmentManager) :FragmentPagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            return fraglist.get(position)
        }

        override fun getCount(): Int {
            return fraglist.size
        }

//        override fun getPageTitle(position: Int): CharSequence? {
//            return name.get(position)
//        }
    }
}