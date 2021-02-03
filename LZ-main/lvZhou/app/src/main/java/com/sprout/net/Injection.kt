package com.sprout.net

import android.util.Log
import com.sprout.net.repository.SystemRepository

/**
 * 数据仓库的代理类
 */
object Injection {
    // 创建数据仓库  这里的lazy类似java中的饿汉单例
    val repository:SystemRepository by lazy {
        SystemRepository()
    }
}