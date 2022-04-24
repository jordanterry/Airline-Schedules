dependencies {
    api(project(":foundations:networking:api"))
    api(project(":foundations:networking:di"))
    implementation(project(":foundations:networking:implementation"))
}
subprojects {
    tasks.withType<Jar> {
        val thisProjectName = project.name
        val parentProjectName = project.parent!!.name
        archiveFileName.set("$parentProjectName-$thisProjectName.jar")
    }
}