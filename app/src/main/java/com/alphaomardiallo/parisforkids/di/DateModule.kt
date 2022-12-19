package com.alphaomardiallo.parisforkids.di

import com.alphaomardiallo.parisforkids.common.domain.util.date.DateUtil
import com.alphaomardiallo.parisforkids.common.domain.util.date.DateUtilImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DateModule {

    @Singleton
    @Provides
    fun provideDateUtil(): DateUtil = DateUtilImp()
}