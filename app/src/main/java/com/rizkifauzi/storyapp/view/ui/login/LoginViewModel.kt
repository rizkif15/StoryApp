package com.rizkifauzi.storyapp.view.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rizkifauzi.storyapp.data.UserRepo
import com.rizkifauzi.storyapp.data.pref.UserModel
import kotlinx.coroutines.launch

class LoginViewModel (private val repository: UserRepo) : ViewModel() {
    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }
}