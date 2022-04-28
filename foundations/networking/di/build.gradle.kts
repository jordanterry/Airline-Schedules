plugins {
    kotlin("kapt")
}

dependencies {
    implementation(libs.dagger.core)
    api(project(":foundations:networking:api"))
    implementation(project(":foundations:networking:implementation"))
    implementation(libs.bundles.json)
    kapt(libs.dagger.compiler)
}
