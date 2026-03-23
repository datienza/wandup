package com.template.app.di

import com.squareup.anvil.annotations.MergeComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@MergeComponent(AppScope::class)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }
}
