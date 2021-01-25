package com.sprout.viewmodel.home.gz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sprout.base.BaseViewModel
import com.sprout.bean.TrendsListData
import com.sprout.net.Injection
import kotlinx.coroutines.launch

class GZViewModel:BaseViewModel(Injection.repository) {

    var data :MutableLiveData<List<TrendsListData.Data>> = MutableLiveData()


    fun trendsList(command:Int,page : Int,size : Int){
        viewModelScope.launch {
            var result = repository.trendsList(command, page, size)
            if(result.errno == 0){
                data.postValue(result.data)
            }

        }

    }
}