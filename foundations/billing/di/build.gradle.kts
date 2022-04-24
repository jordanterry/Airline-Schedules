plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {

    api(project(":foundations:billing:api"))
    implementation(project(":foundations:billing:implementation"))

    implementation(libs.dagger.core)
    kapt(libs.dagger.compiler)
}