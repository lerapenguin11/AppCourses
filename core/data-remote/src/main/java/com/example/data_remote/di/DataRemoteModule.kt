package com.example.data_remote.di

import dagger.Module

@Module(includes = [RetrofitModule::class, ApiModule::class])
interface DataRemoteModule