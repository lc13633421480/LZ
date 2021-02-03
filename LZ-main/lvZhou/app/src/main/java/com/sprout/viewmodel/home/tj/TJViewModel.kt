package com.sprout.viewmodel.home.tj

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sprout.base.BaseViewModel
import com.sprout.bean.ChannelData
import com.sprout.bean.Data
import com.sprout.net.Injection
import kotlinx.coroutines.launch

class TJViewModel:BaseViewModel(Injection.repository) {
    var data : MutableLiveData<List<Data>> = MutableLiveData()

     fun channel(){
        viewModelScope.launch {
            var result = repository.channel()
            if (result.errno == 0){
                data.postValue(result.data)
            }
        }
    }
}