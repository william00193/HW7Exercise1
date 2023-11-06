package com.example.hw7exercise1

import android.app.Application

class CriminalIntentApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }

}