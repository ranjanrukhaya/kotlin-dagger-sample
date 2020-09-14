package com.gaura.kotlindaggersample

import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedPrefModule::class])
interface SharedPrefComponent {
    fun inject(activity: MainActivity)
}