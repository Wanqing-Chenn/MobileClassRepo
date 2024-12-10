// settings.gradle.kts

pluginManagement {
    repositories {
        google()  // Required for Android plugins
        mavenCentral()  // General repository for other dependencies
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.6.1" apply false  // Apply Android plugin (version 8.6.1)
        id("org.jetbrains.kotlin.android") version "2.0.20" apply false  // Kotlin plugin (adjust version if necessary)
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    }
}

rootProject.name = "MobileClassRepo-master"
include("app")
