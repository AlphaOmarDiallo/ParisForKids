package com.alphaomardiallo.parisforkids.di

import com.alphaomardiallo.parisforkids.data.local.EventsDAO
import com.alphaomardiallo.parisforkids.data.repository.events.EventsRepository
import com.alphaomardiallo.parisforkids.data.repository.events.EventsRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class EventsModule {

    @Singleton
    @Provides
    fun provideEventsRepository(eventsDAO: EventsDAO): EventsRepository =
        EventsRepositoryImp(eventsDAO)
}