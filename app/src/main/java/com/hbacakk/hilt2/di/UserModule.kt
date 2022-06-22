package com.hbacakk.hilt2.di

import android.content.Context
import com.hbacakk.hilt2.data.local.PrefManager
import com.hbacakk.hilt2.util.UserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Provides
    @Singleton
    fun provideUserManager(
        @ApplicationContext context: Context,
        prefManager: PrefManager
    ): UserManager = UserManager(context, prefManager)

}