plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.anvil)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.template.feature.home.ui"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:coroutines:api"))
    implementation(project(":feature:home:api"))
    implementation(project(":ui:arch"))
    implementation(project(":ui:design"))

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // DI
    implementation(libs.anvil.annotations)
    implementation(libs.dagger)
    implementation(libs.javax.inject)
    ksp(libs.dagger.compiler)
}
