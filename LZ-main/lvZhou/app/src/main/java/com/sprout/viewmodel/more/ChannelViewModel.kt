package com.sprout.vm.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.sprout.base.BaseViewModel
import com.sprout.bean.Data
import com.sprout.net.Injection
import kotlinx.coroutines.launch

class ChannelViewModel: BaseViewModel(Injection.repository) {

    var data : MutableLiveData<List<Data>> = MutableLiveData()

    /**
     * 获取频道数据
     */
    fun channel(){
        viewModelScope.launch {
            var result = repository.channel()
            if (result.errno == 0){
                data.postValue(result.data)
            }
        }
    }
}