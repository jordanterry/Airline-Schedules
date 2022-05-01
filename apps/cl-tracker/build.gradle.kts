plugins {
    kotlin("kapt")
    id("application")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.flyingandroid"
version = "1.0-SNAPSHOT"

project.setProperty("mainClassName", "com.flyingandroid.fsscheduler.planner.PlannerKt")

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

dependencies {
    implementation(libs.dagger.core)
    implementation(libs.coroutines)
    kapt(libs.dagger.compiler)
    implementation(project(":foundations:networking"))
    implementation(project(":foundations:billing"))
    implementation(project(":features:flight-aware"))
    implementation(project(":features:schedules"))
}