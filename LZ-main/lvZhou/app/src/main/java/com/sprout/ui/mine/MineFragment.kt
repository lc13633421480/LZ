package com.sprout.ui.mine

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sprout.R
import com.sprout.base.BaseFragment
import com.sprout.databinding.LayoutMinefragBinding
import com.sprout.ui.home.GZFrag
import com.sprout.ui.home.TCFrag
import com.sprout.ui.home.tj.TJFrag
import com.sprout.viewmodel.mine.MineViewModel
import kotlinx.android.synthetic.main.layout_homefrag.*

class MineFragment:BaseFragment<MineViewModel,LayoutMinefragBinding>(R.layout.layout_minefrag,MineViewModel::class.java) {
    companion object{
        val instance by lazy { MineFragment() }
    }
    lateinit var oneFrag:Fragment
    lateinit var twoFrag:Fragment
    lateinit var threeFrag:Fragment
    lateinit var fineFrag:Fragment

    val fraglist = ArrayList<Fragment>()
    val name = ArrayList<String>()
    override fun initView() {
        fraglist.clear()
        oneFrag = OneFrag()
        twoFrag = TowFrag()
        threeFrag = ThreeFrag()
        fineFrag = FineFrag()


        fraglist.add(oneFrag)
        fraglist.add(twoFrag)
        fraglist.add(threeFrag)
        fraglist.add(fineFrag)


        mDataBinding.mVpMe.adapter = vpAdapter(childFragmentManager)
        mDataBinding.mTabMe.setupWithViewPager(mDataBinding.mVpMe)

        mDataBinding.mTabMe.getTabAt(0)?.setIcon(R.drawable.selector_status)
        mDataBinding.mTabMe.getTabAt(1)?.setIcon(R.drawable.selector_like)
        mDataBinding.mTabMe.getTabAt(2)?.setIcon(R.drawable.selector_favorite)
        mDataBinding.mTabMe.getTabAt(3)?.setIcon(R.drawable.selector_at)
    }

    override fun initVM() {

    }

    override fun initData() {

    }

    override fun initVariable() {

    }

    inner class vpAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
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