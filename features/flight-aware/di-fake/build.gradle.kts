plugins {
    kotlin("kapt")
}

dependencies {
    implementation(project(":features:flight-aware:api"))
    implementation(project(":features:flight-aware:json"))
    implementation(project(":features:flight-aware:implementation-fake"))
    implementation(project(":foundations:networking:di"))
    implementation(project(":foundations:billing:di"))
    implementation(libs.dagger.core)
    implementation(libs.bundles.json)
    kapt(libs.dagger.compiler)
}