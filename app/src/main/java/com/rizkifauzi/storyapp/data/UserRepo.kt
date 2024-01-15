package com.rizkifauzi.storyapp.data

import com.rizkifauzi.storyapp.data.pref.UserModel
import com.rizkifauzi.storyapp.data.pref.UserPreference
import kotlinx.coroutines.flow.Flow

class UserRepo private constructor(private val userPreference: UserPreference) {

    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    companion object {
        @Volatile
        private var instance: UserRepo? = null
        fun getInstance(
            userPreference: UserPreference
        ): UserRepo =
            instance ?: synchronized(this) {
                instance ?: UserRepo(userPreference)
            }.also { instance = it }
    }
}