// Module-level build.gradle.kts (e.g., app/build.gradle.kts)
plugins {
    id("com.android.application") version "8.6.1"
    id("org.jetbrains.kotlin.android") version "2.0.20"
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.kotlin.stdlib)
    implementation(libs.cardview)
    implementation(libs.appcompat)
    implementation(libs.recyclerview)
    implementation(libs.material)
    implementation(libs.junit)  // Make sure this dependency is added
}

repositories {
    google()
    mavenCentral()
}
