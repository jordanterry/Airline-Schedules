plugins {
    kotlin("kapt")
}

dependencies {
    api(project(":foundations:schema"))
    implementation(libs.inject)
    implementation(libs.bundles.json)
    implementation(libs.bundles.io)
    kapt(libs.moshi.kotlin.codegen)
}