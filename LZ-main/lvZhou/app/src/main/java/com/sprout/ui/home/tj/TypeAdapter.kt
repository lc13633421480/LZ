package com.shop.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


import com.sprout.ui.home.tj.TypeInfoFragment

class TypeAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm){

    private var arrayList = ArrayList<TypeInfoFragment>()

    private var tabName = ArrayList<String>()

    fun addList(
        arrayList: ArrayList<TypeInfoFragment>,

        tabName: java.util.ArrayList<String>
    ){
        this.arrayList = arrayList
        this.tabName = tabName
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return arrayList.get(position)
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabName.get(position)
//        return category.get(position).name
    }
}