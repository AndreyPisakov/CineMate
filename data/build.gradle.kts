import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.google.gms.google-services")
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.pisakov.data"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val keystoreFile = project.rootProject.file("data/apikey.properties")
        val properties = Properties()
        val kinopoiskApiKey = "KINOPOISK_API_KEY"
        val tmdbApiKey = "TMDB_API_KEY"
        properties.load(keystoreFile.inputStream())
        buildConfigField(
            type = "String",
            name = kinopoiskApiKey,
            value = properties.getProperty(kinopoiskApiKey) ?: ""
        )
        buildConfigField(
            type = "String",
            name = tmdbApiKey,
            value = properties.getProperty(tmdbApiKey) ?: ""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    android.buildFeatures.buildConfig = true
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.core)
    implementation(libs.appcompat)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.okhttp)
    implementation(libs.retrofit.lib)
    implementation(libs.retrofit.gsonConverter)
    implementation(libs.okhttp.logInterceptor)

    implementation(libs.coroutines.core)

    implementation(libs.firebase.database)

    implementation(libs.timber)
}
