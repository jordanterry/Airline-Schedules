dependencies {
    api(project(":core:flight-aware:api"))
    api(project(":core:flight-aware:di-fake"))
//    api(project(":core:flight-aware:di"))
//    implementation(project(":core:flight-aware:implementation"))
    implementation(project(":core:flight-aware:implementation-fake"))
}
subprojects {
    tasks.withType<Jar> {
        val thisProjectName = project.name
        val parentProjectName = project.parent!!.name
        archiveFileName.set("$parentProjectName-$thisProjectName.jar")
    }
}