dependencies {
    api(project(":features:flight-aware:api"))
    api(project(":features:flight-aware:di"))
    implementation(project(":features:flight-aware:implementation"))

//    api(project(":features:flight-aware:di-fake"))
//    implementation(project(":features:flight-aware:implementation-fake"))
}
subprojects {
    tasks.withType<Jar> {
        val thisProjectName = project.name
        val parentProjectName = project.parent!!.name
        archiveFileName.set("$parentProjectName-$thisProjectName.jar")
    }
}