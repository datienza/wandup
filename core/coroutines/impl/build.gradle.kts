plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.anvil)
}

dependencies {
    api(project(":core:coroutines:api"))
    implementation(libs.anvil.annotations)
    implementation(libs.dagger)
    implementation(libs.javax.inject)
}
