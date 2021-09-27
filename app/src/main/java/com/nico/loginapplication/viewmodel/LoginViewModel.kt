package com.nico.loginapplication.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.nico.loginapplication.model.User

class LoginViewModel : ViewModel() {

    val user = MutableLiveData<User>()
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    private var userMutableLiveData: MutableLiveData<User>? = null


}