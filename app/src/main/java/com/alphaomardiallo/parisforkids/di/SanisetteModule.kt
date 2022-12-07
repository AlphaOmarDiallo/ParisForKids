package com.alphaomardiallo.parisforkids.di

import com.alphaomardiallo.parisforkids.common.data.remote.RetrofitSanisette
import com.alphaomardiallo.parisforkids.common.data.repository.sanisette.SanisetteRepository
import com.alphaomardiallo.parisforkids.common.data.repository.sanisette.SanisetteRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SanisetteModule {

    @Singleton
    @Provides
    fun provideSanisetteRepository(retrofitSanisette: RetrofitSanisette): SanisetteRepository =
        SanisetteRepositoryImp(retrofitSanisette)
}