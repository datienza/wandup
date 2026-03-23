plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.anvil)
}

dependencies {
    implementation(project(":backend:core"))
    implementation(libs.anvil.annotations)
    implementation(libs.dagger)
    implementation(libs.javax.inject)
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
}
