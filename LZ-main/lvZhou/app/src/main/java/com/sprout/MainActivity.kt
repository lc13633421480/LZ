package com.sprout

import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.sprout.base.BaseActivity
import com.sprout.databinding.ActivityMainBinding
import com.sprout.ui.discover.DiscoverFragment
import com.sprout.ui.home.HomeFragment
import com.sprout.ui.message.MessageFragment
import com.sprout.ui.mine.MineFragment
import com.sprout.ui.more.MoreEditorActivity
import com.sprout.viewmodel.MainViewModel
import kotlin.math.min

class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>
    (R.layout.activity_main,MainViewModel::class.java) , View.OnClickListener{
    lateinit var homeFragment: HomeFragment
    lateinit var decoverFragment: Fragment
    lateinit var messageFragment: Fragment
    lateinit var mineFragment: Fragment

    companion object{
        val instance by lazy { MainActivity()
        }}

    override fun initView() {
        homeFragment = HomeFragment.instance
        decoverFragment = DiscoverFragment.instance
        messageFragment = MessageFragment.instance
        mineFragment = MineFragment.instance

        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragments,homeFragment)
        mDataBinding.imgHome.setImageResource(R.mipmap.main_nav_home_hl)
        transaction.commit()

        mDataBinding.layoutHome.setOnClickListener(this)
        mDataBinding.layoutDiscover.setOnClickListener(this)
        mDataBinding.layoutMore.setOnClickListener(this)
        mDataBinding.layoutMessage.setOnClickListener(this)
        mDataBinding.layoutMine.setOnClickListener(this)
    }

    override fun initVM() {

    }

    override fun initData() {

    }

    override fun initVariable() {

    }

    override fun onClick(v: View?) {
//        //初始化fragment
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        when(v!!.id){
            R.id.layout_home -> {
                resetImg()
                mDataBinding.imgHome.setImageResource(R.mipmap.main_nav_home_hl)
                transaction.replace(R.id.fragments,homeFragment)
                transaction.commit()
            }
            R.id.layout_discover -> {
                resetImg()
                mDataBinding.imgDiscover.setImageResource(R.mipmap.main_nav_discover_hl)
                transaction.replace(R.id.fragments,decoverFragment)
                transaction.commit()
            }
            R.id.layout_more -> {
               var intent = Intent(this,MoreEditorActivity::class.java)
                startActivity(intent)
            }
            R.id.layout_message -> {
                resetImg()
                mDataBinding.imgMessage.setImageResource(R.mipmap.main_nav_message_hl)
                transaction.replace(R.id.fragments,messageFragment)
                transaction.commit()
            }
            R.id.layout_mine -> {
                resetImg()
                mDataBinding.imgMine.setImageResource(R.mipmap.main_nav_mine_hl)
                transaction.replace(R.id.fragments, mineFragment)
                transaction.commit()
            }
        }
    }

    private fun resetImg(){
        mDataBinding.imgHome.setImageResource(R.mipmap.main_nav_home_normal)
        mDataBinding.imgDiscover.setImageResource(R.mipmap.main_nav_discover_normal)
        mDataBinding.imgMessage.setImageResource(R.mipmap.main_nav_message_normal)
        mDataBinding.imgMine.setImageResource(R.mipmap.main_nav_mine_normal)
    }

}