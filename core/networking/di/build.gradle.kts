plugins {
    kotlin("kapt")
}

dependencies {
    implementation(libs.dagger.core)
    implementation(project(":core:networking:api"))
    implementation(project(":core:networking:implementation"))
    kapt(libs.dagger.compiler)
}
