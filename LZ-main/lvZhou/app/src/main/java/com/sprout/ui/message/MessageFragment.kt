package com.sprout.ui.message

import androidx.fragment.app.Fragment
import com.sprout.R
import com.sprout.base.BaseFragment
import com.sprout.databinding.LayoutMessagefragBinding
import com.sprout.viewmodel.message.MessageViewModel

class MessageFragment:BaseFragment<MessageViewModel,LayoutMessagefragBinding>(R.layout.layout_messagefrag,MessageViewModel::class.java) {
    companion object{
        val instance by lazy { MessageFragment() }
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