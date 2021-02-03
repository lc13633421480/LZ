package com.sprout.viewmodel.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sprout.base.BaseViewModel
import com.sprout.bean.Data
import com.sprout.bean.LoginData
import com.sprout.net.Injection
import kotlinx.coroutines.launch

class LogViewModel : BaseViewModel(Injection.repository) {
    var info : MutableLiveData<LoginData> = MutableLiveData()

    fun login(username:String,password:String){
        viewModelScope.launch {
            var result = repository.login(username, password)
            if (result.errno == 0){
                info.postValue(result.data)
            }
        }
    }
}