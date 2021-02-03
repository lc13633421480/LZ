package com.sprout.ui.more

import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sprout.BR
import com.sprout.R
import com.sprout.base.BaseActivity
import com.sprout.base.IItemClick
import com.sprout.bean.BrandData
import com.sprout.bean.GoodData
import com.sprout.databinding.ActivityTagsBinding

import com.sprout.ui.more.adapter.BrandAdapter
import com.sprout.ui.more.adapter.GoodAdapter
import com.sprout.vm.more.TagsViewModel
import kotlinx.android.synthetic.main.activity_tags.*

class TagsActivity:BaseActivity<TagsViewModel,ActivityTagsBinding>(R.layout.activity_tags,TagsViewModel::class.java) {

    lateinit var brandList:MutableList<BrandData.Data>
    lateinit var brandAdapter:BrandAdapter

    lateinit var goodList:MutableList<GoodData.Data>
    lateinit var goodAdapter: GoodAdapter


    override fun initData() {

    }

    override fun initVM() {
        mViewModel.bList.observe(this, Observer {
            brandList.clear()
            brandList.addAll(it.data)
            recyTags.adapter = brandAdapter
        })

        mViewModel.gList.observe(this, Observer {
            goodList.clear()
            goodList.addAll(it.data)
            recyTags.adapter = goodAdapter
        })
    }

    override fun initVariable() {

    }

    override fun initView() {
        recyTags.layoutManager = LinearLayoutManager(this)

        var brandArr = SparseArray<Int>()
        brandArr.put(R.layout.layout_brand_item,BR.brandData)
        brandList = mutableListOf()
        brandAdapter = BrandAdapter(this,brandList,brandArr,BrandClick())

        var goodArr = SparseArray<Int>()
        goodArr.put(R.layout.layout_good_item,BR.goodData)
        goodList = mutableListOf()
        goodAdapter = GoodAdapter(this,goodList,goodArr,GoodClick())

        mDataBinding.tagClick = TagsClick()
    }


    inner class BrandClick: IItemClick<BrandData.Data> {
        override fun itemClick(data: BrandData.Data) {
            intent.putExtra("name",data.name)
            intent.putExtra("id",data.id)
            setResult(1,intent)
            finish()
        }

    }

    inner class GoodClick:IItemClick<GoodData.Data>{
        override fun itemClick(data: GoodData.Data) {
            intent.putExtra("name",data.name)
            intent.putExtra("id",data.id)
            setResult(2,intent)
            finish()
        }

    }

    inner class TagsClick{
        fun click(type:Int){
            when(type){
                1->{
                    if(brandList.size == 0){
                        mViewModel.getBrand(0,10)
                    }else{
                        recyTags.adapter = brandAdapter
                    }
                }
                2->{
                    if(goodList.size == 0){
                        mViewModel.getGood(1,10)
                    }else{
                        recyTags.adapter = goodAdapter
                    }
                }
                3->{

                }
                4->{

                }
            }
        }
    }


}