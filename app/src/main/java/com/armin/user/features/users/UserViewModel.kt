package com.armin.user.features.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.armin.user.api.UserApi
import com.armin.user.data.UserItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    api: UserApi
) : ViewModel() {
    private val usersLiveData = MutableLiveData<List<UserItem>>()
    val users: LiveData<List<UserItem>> = usersLiveData

    init {
        viewModelScope.launch {
            val users = api.getUser()
            delay(2000)
            usersLiveData.value = users
        }
    }
}