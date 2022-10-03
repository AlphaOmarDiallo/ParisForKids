package com.alphaomardiallo.parisforkids.di

import com.alphaomardiallo.parisforkids.data.local.EventsAndActivitiesDAO
import com.alphaomardiallo.parisforkids.data.repository.eventsAndActivities.EventsAndActivitiesRepository
import com.alphaomardiallo.parisforkids.data.repository.eventsAndActivities.EventsAndActivitiesRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class EventsAndActivitiesModule {

    @Singleton
    @Provides
    fun provideEventsAndActivitiesRepository(eventsAndActivitiesDAO: EventsAndActivitiesDAO): EventsAndActivitiesRepository =
        EventsAndActivitiesRepositoryImp(eventsAndActivitiesDAO)
}