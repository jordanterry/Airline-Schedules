plugins {
    kotlin("kapt")
}

dependencies {
    implementation(project(":features:schedules:implementation"))
    implementation(project(":features:flight-aware:di"))
    implementation(project(":features:flight-aware:json"))
    implementation(project(":features:flight-aware:api"))
    implementation(libs.dagger.core)
    kapt(libs.dagger.compiler)
}