package com.sprout.ui.more.adapter

import android.content.Context
import android.util.SparseArray
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.sprout.BR

import com.sprout.R
import com.sprout.base.BaseAdapter
import com.sprout.base.IItemClick
import com.sprout.bean.GoodData

/**
 * 商品的adapter
 */
class GoodAdapter(
    context: Context,
    list:List<GoodData.Data>,
    layouts:SparseArray<Int>,
    click: IItemClick<GoodData.Data>
): BaseAdapter<GoodData.Data>(context,list,layouts,click) {
    override fun bindData(binding: ViewDataBinding, data: GoodData.Data, layId: Int) {
        binding.setVariable(BR.goodItemClick,itemClick)
        var txt = binding.root.findViewById<TextView>(R.id.tv_name)
        txt.setText(data.name)
    }

    override fun layoutId(position: Int): Int {
        return R.layout.layout_good_item
    }
}