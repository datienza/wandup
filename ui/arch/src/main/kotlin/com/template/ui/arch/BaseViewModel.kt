package com.template.ui.arch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<S : UiState, E : UiEvent, N : NavigationIntent>(
    initialState: S,
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state.asStateFlow()

    protected val currentState: S
        get() = _state.value

    private val _navigation = Channel<N>(Channel.UNLIMITED)
    val navigation = _navigation.receiveAsFlow()

    protected fun setState(reducer: S.() -> S) {
        _state.value = _state.value.reducer()
    }

    protected suspend fun updateState(reducer: S.() -> S) {
        _state.value = _state.value.reducer()
    }

    fun emitEvent(event: E) {
        handleEvent(event, currentState)
    }

    protected open fun handleEvent(event: E, currentState: S) {}

    protected fun navigate(navigationIntent: N) {
        viewModelScope.launch {
            _navigation.send(navigationIntent)
        }
    }

    protected fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit,
    ): Job = viewModelScope.launch(context, block = block)
}

@Composable
fun <S : UiState, N : NavigationIntent> BaseViewModel<S, *, N>.subscribe(
    navigator: Navigator<N>? = null,
): State<S> {
    val lifecycleOwner = LocalLifecycleOwner.current

    if (navigator != null) {
        LaunchedEffect(navigation, lifecycleOwner) {
            lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                navigation.collect { navigator.navigate(it) }
            }
        }
    }

    return state.collectAsStateWithLifecycle()
}
