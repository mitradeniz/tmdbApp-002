@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.example.tmdbapp_002"
    compileSdk = 34

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    

    defaultConfig {
        applicationId = "com.example.tmdbapp_002"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation ("com.google.android.material:material:1.3.0-alpha03")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("androidx.recyclerview:recyclerview:1.3.1")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2.6.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}