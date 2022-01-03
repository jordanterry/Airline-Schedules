dependencies {
    api(project(":core:networking:api"))
    api(project(":core:networking:di"))
    implementation(project(":core:networking:implementation"))
}
subprojects {
    tasks.withType<Jar> {
        val thisProjectName = project.name
        val parentProjectName = project.parent!!.name
        archiveFileName.set("$parentProjectName-$thisProjectName.jar")
    }
}