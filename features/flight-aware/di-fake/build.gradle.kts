plugins {
    kotlin("kapt")
}

dependencies {
    implementation(project(":features:flight-aware:api"))
    implementation(project(":features:flight-aware:json"))
    implementation(project(":features:flight-aware:implementation-fake"))
    implementation(project(":foundations:networking:di"))
    implementation(project(":foundations:billing:di"))
    implementation(libs.bundles.networking)
    implementation(libs.dagger.core)
    kapt(libs.dagger.compiler)
}