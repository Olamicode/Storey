package com.olamachia.multipletableroom.di

import android.app.Application
import androidx.room.Room
import com.olamachia.multipletableroom.dao.SchoolDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): SchoolDatabase =
        Room.databaseBuilder(app, SchoolDatabase::class.java, "school_database")
            .fallbackToDestructiveMigration()
            .build()

}