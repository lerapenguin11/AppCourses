plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:data-remote"))
    implementation(project(":core:data-local"))

    //Dagger
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    //Coroutines
    implementation(libs.kotlinx.coroutines.core)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //Preferences DataStore
    implementation(libs.androidx.datastore.preferences)
}