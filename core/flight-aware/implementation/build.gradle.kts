dependencies {
    implementation(project(":core:billing:api"))
    implementation(project(":core:flight-aware:api"))
    implementation(project(":core:flight-aware:json"))
    implementation(libs.bundles.networking)
    implementation(libs.bundles.async)
    implementation(libs.inject)
}
