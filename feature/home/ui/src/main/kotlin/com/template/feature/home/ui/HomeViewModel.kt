package com.template.feature.home.ui

import com.template.core.coroutines.DispatcherProvider
import com.template.feature.home.api.usecase.GetHomeDataUseCase
import com.template.ui.arch.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase,
    private val dispatcherProvider: DispatcherProvider,
) : BaseViewModel<HomeUiState, HomeEvent, HomeNavigationIntent>(HomeUiState()) {

    init {
        loadHomeData()
    }

    override fun handleEvent(event: HomeEvent, currentState: HomeUiState) {
        when (event) {
            HomeEvent.Refresh -> loadHomeData()
            is HomeEvent.ItemClicked -> navigate(HomeNavigationIntent.NavigateToDetail(event.itemId))
        }
    }

    private fun loadHomeData() {
        launch(dispatcherProvider.io) {
            setState { copy(isLoading = true, error = null) }

            getHomeDataUseCase().fold(
                onSuccess = { data ->
                    setState {
                        copy(
                            isLoading = false,
                            title = data.title,
                            items = data.items,
                        )
                    }
                },
                onFailure = { error ->
                    setState {
                        copy(
                            isLoading = false,
                            error = error.message ?: "Unknown error",
                        )
                    }
                },
            )
        }
    }
}
