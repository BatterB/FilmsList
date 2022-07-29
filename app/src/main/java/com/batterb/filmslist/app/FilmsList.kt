package com.batterb.filmslist.app

import android.app.Application
import com.batterb.filmslist.di.AppComponent
import com.batterb.filmslist.di.DaggerAppComponent
import com.batterb.filmslist.di.ViewModelModule

class FilmsList : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .viewModelModule(ViewModelModule(this))
            .build()
    }
}