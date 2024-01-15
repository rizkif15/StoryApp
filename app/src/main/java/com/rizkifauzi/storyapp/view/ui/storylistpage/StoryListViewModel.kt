package com.rizkifauzi.storyapp.view.ui.storylistpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.rizkifauzi.storyapp.data.UserRepo
import com.rizkifauzi.storyapp.data.pref.UserModel
import kotlinx.coroutines.launch

class StoryListViewModel (private val repository: UserRepo) : ViewModel() {
    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}