package com.sprout.ui.home.tj

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import com.shop.adapter.TypeAdapter
import com.sprout.R
import com.sprout.base.BaseFragment
import com.sprout.bean.ChannelData
import com.sprout.bean.Data
import com.sprout.databinding.LayoutTjfragBinding
import com.sprout.viewmodel.home.tj.TJViewModel
import kotlinx.android.synthetic.main.layout_tjfrag.*
import java.util.ArrayList

class TJFrag:BaseFragment<TJViewModel,LayoutTjfragBinding>(R.layout.layout_tjfrag,
    TJViewModel::class.java) {

    companion object{
        val instance by lazy { TJFrag() }
    }

    override fun initView() {

    }

    override fun initData() {
        mViewModel.channel()

    }

    override fun initVM() {
        val fragments = ArrayList<TypeInfoFragment>()
        val tabName = ArrayList<String>()
        if(!isAdded)return
        mViewModel.data.observe(this, Observer {
//            fragments.clear()
            for (i  in it.indices){
//                var id = listcl.get(i).id
                tabName.add(it.get(i).name)
                var typeInfoFragment = TypeInfoFragment()
//                var bundle = Bundle()
//                bundle.putInt("id",id)
//                typeInfoFragment.arguments = bundle
                fragments.add(typeInfoFragment)
                Log.e("111", "initVM: "+it )
            }

            var typeAdapter = TypeAdapter(childFragmentManager)
            typeAdapter.addList(fragments,tabName)
            vp_tj.adapter = typeAdapter
            tab_tj.setupWithViewPager(vp_tj)
        })
    }


    override fun initVariable() {

    }
}