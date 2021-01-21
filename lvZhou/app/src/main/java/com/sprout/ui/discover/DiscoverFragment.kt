package com.sprout.ui.discover

import androidx.fragment.app.Fragment
import com.sprout.R
import com.sprout.base.BaseFragment
import com.sprout.databinding.LayoutDiscoverfragBinding
import com.sprout.viewmodel.discover.DiscoverViewModel

class DiscoverFragment:BaseFragment<DiscoverViewModel,LayoutDiscoverfragBinding>(R.layout.layout_discoverfrag,DiscoverViewModel::class.java) {
    companion object{
        val instance by lazy { DiscoverFragment() }
    }

    override fun initView() {

    }

    override fun initVM() {

    }

    override fun initData() {

    }

    override fun initVariable() {

    }

}