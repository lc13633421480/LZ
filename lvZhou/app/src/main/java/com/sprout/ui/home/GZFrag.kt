package com.sprout.ui.home

import android.util.Log
import android.util.SparseArray
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sprout.BR
import com.sprout.R
import com.sprout.adapter.home.gz.GZAdapter
import com.sprout.base.BaseFragment
import com.sprout.base.IItemClick
import com.sprout.bean.TrendsListData
import com.sprout.databinding.LayoutGzfragBinding
import com.sprout.model.BrandData
import com.sprout.viewmodel.home.gz.GZViewModel
import kotlinx.android.synthetic.main.layout_gzfrag.*

class GZFrag:BaseFragment<GZViewModel,LayoutGzfragBinding>(R.layout.layout_gzfrag,GZViewModel::class.java) {
    var trends : MutableList<TrendsListData.Data> = mutableListOf()
    var adapter : GZAdapter? = null
    companion object{
        val instance by lazy { GZFrag() }
    }

    override fun initView() {
        rlv_gz.layoutManager = StaggeredGridLayoutManager(2,LinearLayout.VERTICAL)
        var array = SparseArray<Int>()
        array.put(R.layout.item_rlv_gz,BR.vmTrend)
        adapter = activity?.let { GZAdapter(it,trends,array,TrendClick()) }
    }

    override fun initVM() {
        mViewModel.data.observe(this, Observer {
            trends.clear()
            trends.addAll(it)
//            rlv_gz.adapter = adapter
            adapter!!.notifyDataSetChanged()
        })
    }

    override fun initData() {
        mViewModel.trendsList(2,1,5)
    }

    override fun initVariable() {

    }

    inner class TrendClick: IItemClick<TrendsListData.Data> {
        override fun itemClick(data: TrendsListData.Data) {
        }
    }
}