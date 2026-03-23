# Wandup

A modular Android project template following Clean Architecture and best practices.

## Architecture

```
├── app/                          # Main application module
├── core/                         # Core utilities
│   ├── common/                   # Extensions, Result wrapper
│   ├── coroutines/               # DispatcherProvider (api/impl)
│   └── network/                  # Network setup (api/impl)
├── ui/                           # UI layer foundations
│   ├── arch/                     # BaseViewModel, UiState, UiEvent
│   └── design/                   # Theme, components
├── backend/                      # Network/API layer
│   ├── core/                     # Base network utilities
│   └── home/                     # Feature-specific API, DTOs
└── feature/                      # Feature modules
    └── home/
        ├── api/                  # Interfaces, models
        ├── impl/                 # Implementations
        └── ui/                   # ViewModel, Screen
```

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **DI**: Anvil + Dagger
- **Async**: Coroutines + Flow
- **Architecture**: MVVM + Clean Architecture

## Key Patterns

### BaseViewModel

```kotlin
class MyViewModel @Inject constructor(
    private val myUseCase: MyUseCase,
) : BaseViewModel<MyUiState, MyEvent, MyNavigationIntent>(MyUiState()) {

    override fun handleEvent(event: MyEvent, currentState: MyUiState) {
        when (event) {
            MyEvent.Refresh -> loadData()
        }
    }

    private fun loadData() {
        launch {
            setState { copy(isLoading = true) }
            // ...
        }
    }
}
```

### Anvil DI

```kotlin
@Singleton
@ContributesBinding(AppScope::class)
class MyRepositoryImpl @Inject constructor() : MyRepository
```

## Module Dependencies

- `feature:home:ui` → `feature:home:api`, `ui:arch`, `ui:design`
- `feature:home:impl` → `feature:home:api`, `backend:home`
- `backend:home` → `backend:core`

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle
4. Run the app

## License

MIT
