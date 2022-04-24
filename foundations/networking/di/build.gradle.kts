plugins {
    kotlin("kapt")
}

dependencies {
    implementation(libs.dagger.core)
    implementation(project(":foundations:networking:api"))
    implementation(project(":foundations:networking:implementation"))
    
    kapt(libs.dagger.compiler)
}
