package com.sprout.vm.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.sprout.base.BaseViewModel
import com.sprout.model.ThemeData

import com.sprout.net.Injection

import kotlinx.coroutines.launch

class ThemeViewModel: BaseViewModel(Injection.repository) {

    var list:MutableLiveData<List<ThemeData>> = MutableLiveData()

    fun getTheme(){
        viewModelScope.launch {
            list.postValue(repository.getTheme().data)
        }
    }

}