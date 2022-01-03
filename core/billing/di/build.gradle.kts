plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    implementation(kotlin("stdlib"))
    api(project(":core:billing:api"))
    implementation(project(":core:billing:implementation"))
    implementation(libs.dagger.core)
    kapt(libs.dagger.compiler)
}