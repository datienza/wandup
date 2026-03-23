plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.anvil)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.template.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.template.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
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
    // Modules
    implementation(project(":core:common"))
    implementation(project(":core:coroutines:api"))
    implementation(project(":core:coroutines:impl"))
    implementation(project(":ui:arch"))
    implementation(project(":ui:design"))
    implementation(project(":feature:home:api"))
    implementation(project(":feature:home:impl"))
    implementation(project(":feature:home:ui"))
    implementation(project(":backend:core"))
    implementation(project(":backend:home"))

    // AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.navigation.compose)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // DI
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)
}
