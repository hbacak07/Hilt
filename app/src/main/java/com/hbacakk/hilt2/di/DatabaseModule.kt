package com.hbacakk.hilt2.di

import android.content.Context
import com.hbacakk.hilt2.data.local.PrefManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providePrefManager(@ApplicationContext context: Context) = PrefManager(context)

}