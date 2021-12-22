package com.mwakisha.kwiktabu.di

import android.content.Context
import androidx.room.Room
import com.mwakisha.kwiktabu.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        AppDatabase.DATABASE_NAME
    ).createFromAsset("databases/kwiktabu.db")
        .fallbackToDestructiveMigration()
        .build();
}