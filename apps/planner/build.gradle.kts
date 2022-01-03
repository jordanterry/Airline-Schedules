plugins {
    kotlin("kapt")
    id("com.jakewharton.mosaic")
    id("application")
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = "com.flyingandroid"
version = "1.0-SNAPSHOT"


application {
    mainClass.set("com.flyingandroid.fsscheduler.planner.PlannerKt")
}
tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

dependencies {
    implementation(libs.dagger.core)
    implementation(libs.coroutines)
    kapt(libs.dagger.compiler)
    implementation(project(":core:networking"))
    implementation(project(":core:billing"))
    implementation(project(":core:flight-aware"))
}