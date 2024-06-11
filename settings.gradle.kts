pluginManagement {
    repositories {
        google()
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
//        maven { setUrl("../../../prebuilts/sdk/current/androidx/m2repository") }
//        maven { setUrl("../../../prebuilts/fullsdk-darwin/extras/android/m2repository") }
//        maven { setUrl("../../../prebuilts/fullsdk-linux/extras/android/m2repository") }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
//        maven { setUrl("../../../prebuilts/sdk/current/androidx/m2repository") }
//        maven { setUrl("../../../prebuilts/fullsdk-darwin/extras/android/m2repository") }
//        maven { setUrl("../../../prebuilts/fullsdk-linux/extras/android/m2repository") }
        google()
        mavenCentral()
    }
}

rootProject.name = "Launcher3-15"
include(":app")
include(":SharedLibWrapper")
include(":IconLoader")
include(":AnimationLib")
include(":SystemUI")