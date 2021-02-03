package com.sprout.adapter.home.gz

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.sprout.R
import com.sprout.base.BaseAdapter

import com.sprout.base.IItemClick
import com.sprout.bean.TrendsData


class GZAdapter(context: Context, list: List<TrendsData>, layouts : SparseArray<Int>,
                var click: IItemClick<TrendsData>)
    : BaseAdapter<TrendsData>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
       return R.layout.item_rlv_gz
    }

    override fun bindData(binding: ViewDataBinding, data: TrendsData, layId: Int) {
    }
}