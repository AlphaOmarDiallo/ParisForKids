package com.alphaomardiallo.parisforkids.di

import com.alphaomardiallo.parisforkids.data.remote.RetrofitQueFaireAParis
import com.alphaomardiallo.parisforkids.data.repository.queFaireAParis.QueFaireAParisRepository
import com.alphaomardiallo.parisforkids.data.repository.queFaireAParis.QueFaireAParisRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class QueFaireAParisModule {

    @Singleton
    @Provides
    fun provideQueFaireAParisRepository(retrofitQueFaireAParis: RetrofitQueFaireAParis): QueFaireAParisRepository =
        QueFaireAParisRepositoryImp(retrofitQueFaireAParis)
}