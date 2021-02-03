package com.sprout.ui.more.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.sprout.BR
import com.sprout.R
import com.sprout.base.BaseAdapter
import com.sprout.base.IItemClick
import com.sprout.bean.Data


/**
 * 频道选择列表
 */
class ChannelAdapter(
        context: Context,
        list: List<Data>,
        layouts:SparseArray<Int>,
        click: IItemClick<Data>
): BaseAdapter<Data>(context,list,layouts,click) {
    override fun bindData(binding: ViewDataBinding, data: Data, layId: Int) {
        binding.setVariable(BR.channelClick,itemClick)
    }

    override fun layoutId(position: Int): Int {
        return R.layout.layout_channel_item

    }
}