plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":foundations:billing:api"))
    implementation(libs.inject)
}