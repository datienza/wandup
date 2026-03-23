plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.anvil)
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":feature:home:api"))
    implementation(project(":backend:home"))
    implementation(libs.anvil.annotations)
    implementation(libs.dagger)
    implementation(libs.javax.inject)
    implementation(libs.kotlinx.coroutines.core)
}
