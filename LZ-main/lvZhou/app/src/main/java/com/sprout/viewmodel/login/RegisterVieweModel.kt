package com.sprout.viewmodel.login

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sprout.base.BaseViewModel
import com.sprout.bean.RegisterMessage
import com.sprout.net.Injection

import kotlinx.coroutines.launch

class RegisterVieweModel:BaseViewModel(Injection.repository) {
    var registerMessage : MutableLiveData<RegisterMessage> = MutableLiveData()

    fun register(userName :String,userPsw:String,imei:String,lng:String,lat:String){
        viewModelScope.launch {
            var result = repository.register(userName, userPsw, imei, lng, lat)
            if (result.errno == 0){
                registerMessage.postValue(result.data)
            }
        }
    }
}