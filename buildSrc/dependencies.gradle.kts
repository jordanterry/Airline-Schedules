dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("kotlin", "1.5.10")
            version("coroutines", "1.6.0")
            version("okhttp", "4.3.1")
            version("retrofit", "2.7.1")
            version("moshi", "1.9.2")
            version("dagger", "2.40.5")
            version("javaxinject", "1")
            version("okio", "3.0.0")

            alias("okhttp").to("com.squareup.okhttp3", "okhttp").versionRef("okhttp")
            alias("retrofit-core").to("com.squareup.retrofit2", "retrofit").versionRef("retrofit")
            alias("retrofit-converter-moshi").to("com.squareup.retrofit2", "converter-moshi").versionRef("retrofit")
            alias("moshi").to("com.squareup.moshi", "moshi-kotlin").versionRef("moshi")

            alias("dagger-core").to("com.google.dagger", "dagger").versionRef("dagger")
            alias("dagger-compiler").to("com.google.dagger", "dagger-compiler").versionRef("dagger")
            alias("inject").to("javax.inject", "javax.inject").versionRef("javaxinject")

            alias("coroutines").to("org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("coroutines")

            alias("okio").to("com.squareup.okio", "okio").versionRef("okio")

            bundle("async", listOf("coroutines"))
            bundle("networking", listOf("okhttp", "retrofit-core", "retrofit-converter-moshi", "moshi"))
            bundle("io", listOf("okio"))
        }
    }
}