plugins {
    kotlin("kapt")
}

dependencies {
    implementation(project(":core:flight-aware:api"))
    implementation(project(":core:flight-aware:json"))
    implementation(project(":core:flight-aware:implementation-fake"))
    implementation(project(":core:networking:di"))
    implementation(project(":core:billing:di"))
    implementation(libs.bundles.networking)
    implementation(libs.dagger.core)
    kapt(libs.dagger.compiler)
}