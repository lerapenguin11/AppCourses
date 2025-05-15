package com.example.data_local.di

import dagger.Module

@Module(includes = [RoomModule::class, DataStoreModule::class])
interface DataLocalModule