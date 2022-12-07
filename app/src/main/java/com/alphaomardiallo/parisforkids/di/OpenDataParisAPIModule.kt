package com.alphaomardiallo.parisforkids.di


import com.alphaomardiallo.parisforkids.common.data.remote.RetrofitQueFaireAParis
import com.alphaomardiallo.parisforkids.common.data.remote.RetrofitSanisette
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OpenDataParisAPIModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    @Singleton
    @Provides
    fun provideApiQueFaireAParis(): RetrofitQueFaireAParis {
        return Retrofit.Builder()
            .baseUrl("https://opendata.paris.fr/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitQueFaireAParis::class.java)
    }

    @Singleton
    @Provides
    fun provideApiSanisette(): RetrofitSanisette {
        return Retrofit.Builder()
            .baseUrl("https://opendata.paris.fr/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitSanisette::class.java)
    }
}