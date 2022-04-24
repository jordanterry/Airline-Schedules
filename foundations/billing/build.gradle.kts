plugins {
    kotlin("jvm")
}

dependencies {
    api(project(":foundations:billing:api"))
    api(project(":foundations:billing:di"))
    implementation(project(":foundations:billing:implementation"))
}
subprojects {
    tasks.withType<Jar> {
        val thisProjectName = project.name
        val parentProjectName = project.parent!!.name
        archiveFileName.set("$parentProjectName-$thisProjectName.jar")
    }
}