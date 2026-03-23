plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.anvil)
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    api(project(":core:network:api"))
    implementation(libs.anvil.annotations)
    implementation(libs.dagger)
    implementation(libs.javax.inject)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlinx.serialization)
}
