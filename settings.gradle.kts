pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CineMate"
include(":app")
include(":domain")
include(":data")
include(":features:main-screen")
include(":features:search")
include(":features:favorite")
include(":features:profile")
include(":auth")
include(":navigation")
