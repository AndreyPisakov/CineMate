plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.dagger.hilt) apply false
    alias(libs.plugins.kapt) apply false
}

buildscript {
    dependencies {
        classpath(libs.google.services)
    }
}