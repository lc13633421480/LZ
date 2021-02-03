package com.sprout.ui.more

import android.content.Intent
import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.sprout.BR
import com.sprout.R
import com.sprout.base.BaseActivity
import com.sprout.base.IItemClick
import com.sprout.bean.Data
import com.sprout.databinding.ActivityChannelBinding
import com.sprout.ui.more.adapter.ChannelAdapter
import com.sprout.vm.more.ChannelViewModel
import kotlinx.android.synthetic.main.activity_channel.*

class ChannelActivity: BaseActivity<ChannelViewModel, ActivityChannelBinding>(R.layout.activity_channel,ChannelViewModel::class.java) {

    var list:MutableList<Data> = mutableListOf()
    lateinit var adapter:ChannelAdapter
    lateinit var mIntent: Intent

    override fun initData() {
        mIntent = intent
        mViewModel.channel()
    }

    override fun initVM() {
        mViewModel.data.observe(this, Observer {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun initVariable() {
    }

    override fun initView() {
        var arr = SparseArray<Int>()
        arr.put(R.layout.layout_channel_item,BR.channel);
        adapter = ChannelAdapter(this,list,arr,ClickEvt())
        recy_channel.layoutManager = LinearLayoutManager(this)
        recy_channel.adapter = adapter
    }

    inner class ClickEvt: IItemClick<Data> {
        override fun itemClick(data: Data) {
            mIntent.putExtra("channelId",data.id)
            mIntent.putExtra("channelName",data.name)
            setResult(102,mIntent)
            finish()
        }

    }
}