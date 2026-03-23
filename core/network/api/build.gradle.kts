plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    api(libs.retrofit)
    implementation(libs.kotlinx.coroutines.core)
}
