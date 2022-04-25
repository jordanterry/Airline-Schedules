dependencies {
    implementation(project(":foundations:billing:api"))
    implementation(project(":features:flight-aware:api"))
    implementation(project(":features:flight-aware:json"))
    implementation(libs.bundles.json)
    implementation(libs.bundles.async)
    implementation(libs.inject)
}