pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "wandup"

include(":app")

// Core modules
include(":core:common")
include(":core:coroutines:api")
include(":core:coroutines:impl")
include(":core:network:api")
include(":core:network:impl")

// UI modules
include(":ui:arch")
include(":ui:design")

// Backend modules
include(":backend:core")
include(":backend:home")

// Feature modules
include(":feature:home:api")
include(":feature:home:impl")
include(":feature:home:ui")
