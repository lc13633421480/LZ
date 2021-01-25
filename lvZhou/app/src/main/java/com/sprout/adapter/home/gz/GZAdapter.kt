package com.sprout.adapter.home.gz

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.sprout.R
import com.sprout.base.BaseAdapter

import com.sprout.base.IItemClick
import com.sprout.bean.TrendsListData

class GZAdapter(context: Context, list: List<TrendsListData.Data>, layouts : SparseArray<Int>,
                var click: IItemClick<TrendsListData.Data>)
    : BaseAdapter<TrendsListData.Data>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
       return R.layout.item_rlv_gz
    }

    override fun bindData(binding: ViewDataBinding, data: TrendsListData.Data, layId: Int) {
    }
}