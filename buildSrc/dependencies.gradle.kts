dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../deps/libs.versions.toml"))
        }
    }
}