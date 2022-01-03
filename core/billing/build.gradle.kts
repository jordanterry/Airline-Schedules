plugins {
    kotlin("jvm")
}

dependencies {
    api(project(":core:billing:api"))
    api(project(":core:billing:di"))
    implementation(project(":core:billing:implementation"))
}
subprojects {
    tasks.withType<Jar> {
        val thisProjectName = project.name
        val parentProjectName = project.parent!!.name
        archiveFileName.set("$parentProjectName-$thisProjectName.jar")
    }
}