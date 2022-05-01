dependencies {
    implementation(project(":foundations:billing:api"))
    implementation(project(":foundations:networking:api"))
    implementation(project(":features:flight-aware:api"))
    implementation(project(":features:flight-aware:json"))
    implementation(libs.bundles.async)
    implementation(libs.moshi)
    implementation(libs.inject)
}
