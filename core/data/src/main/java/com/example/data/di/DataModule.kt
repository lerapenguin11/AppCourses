package com.example.data.di

import com.example.data_local.di.DataLocalModule
import com.example.data_remote.di.DataRemoteModule
import dagger.Module

@Module(includes = [DataLocalModule::class, DataRemoteModule::class, RepositoryModule::class])
interface DataModule