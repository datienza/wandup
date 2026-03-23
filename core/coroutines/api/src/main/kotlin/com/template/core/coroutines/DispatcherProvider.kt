package com.template.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val computation: CoroutineDispatcher
}
