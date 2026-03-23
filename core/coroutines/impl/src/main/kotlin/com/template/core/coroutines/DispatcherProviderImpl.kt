package com.template.core.coroutines

import com.squareup.anvil.annotations.ContributesBinding
import com.template.app.di.AppScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ContributesBinding(AppScope::class)
class DispatcherProviderImpl @Inject constructor() : DispatcherProvider {
    override val io: CoroutineDispatcher = Dispatchers.IO
    override val main: CoroutineDispatcher = Dispatchers.Main
    override val computation: CoroutineDispatcher = Dispatchers.Default
}
