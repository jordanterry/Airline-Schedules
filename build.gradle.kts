import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
        classpath("com.jakewharton.mosaic:mosaic-gradle-plugin:0.1.0")
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    dependencies {
        implementation(kotlin("stdlib"))
    }
    tasks.withType<Jar> {
        duplicatesStrategy = DuplicatesStrategy.INHERIT
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "18"
    }
}
