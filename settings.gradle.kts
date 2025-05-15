pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Courses"
include(":app")
include(":core:ui")
include(":core:designsystem")
include(":core:resources")
include(":feature:auth")
include(":core:navigation")
include(":feature:main")
include(":feature:profile")
include(":core:data")
include(":core:domain")
include(":core:data-local")
include(":core:data-remote")
include(":core:di")
