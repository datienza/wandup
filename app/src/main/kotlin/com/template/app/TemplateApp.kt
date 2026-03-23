package com.template.app

import android.app.Application
import com.template.app.di.AppComponent
import com.template.app.di.DaggerAppComponent

class TemplateApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create()
    }
}
