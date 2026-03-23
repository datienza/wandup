package com.template.feature.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.template.feature.home.api.models.HomeItem
import com.template.ui.arch.subscribe

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
) {
    val state = viewModel.subscribe().value

    HomeContent(
        state = state,
        onItemClick = { viewModel.emitEvent(HomeEvent.ItemClicked(it)) },
        onRefresh = { viewModel.emitEvent(HomeEvent.Refresh) },
    )
}

@Composable
private fun HomeContent(
    state: HomeUiState,
    onItemClick: (String) -> Unit,
    onRefresh: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            state.error != null -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = state.error)
                }
            }
            else -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        Text(
                            text = state.title,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(16.dp),
                        )
                    }
                    items(state.items) { item ->
                        HomeItemCard(
                            item = item,
                            onClick = { onItemClick(item.id) },
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun HomeItemCard(
    item: HomeItem,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = onClick),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
