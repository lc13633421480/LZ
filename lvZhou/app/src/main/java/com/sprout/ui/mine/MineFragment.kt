package com.sprout.ui.mine

import androidx.fragment.app.Fragment
import com.sprout.R
import com.sprout.base.BaseFragment
import com.sprout.databinding.LayoutMinefragBinding
import com.sprout.viewmodel.mine.MineViewModel

class MineFragment:BaseFragment<MineViewModel,LayoutMinefragBinding>(R.layout.layout_minefrag,MineViewModel::class.java) {
    companion object{
        val instance by lazy { MineFragment() }
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