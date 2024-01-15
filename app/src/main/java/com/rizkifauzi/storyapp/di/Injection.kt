package com.rizkifauzi.storyapp.di

import android.content.Context
import com.rizkifauzi.storyapp.data.UserRepo
import com.rizkifauzi.storyapp.data.pref.UserPreference
import com.rizkifauzi.storyapp.data.pref.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepo {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepo.getInstance(pref)
    }
}