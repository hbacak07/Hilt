package com.hbacakk.hilt2.di

import com.hbacakk.hilt2.util.EnglishPerson
import com.hbacakk.hilt2.util.SpanishPerson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PersonModule {

    @Provides
    @Singleton
    fun provideEnglishPerson(): EnglishPerson = EnglishPerson()

    @Provides
    @Singleton
    fun provideSpanishPerson(englishPerson: EnglishPerson): SpanishPerson = SpanishPerson(englishPerson)


}