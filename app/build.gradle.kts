plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.logitask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.logitask"
        minSdk = 30
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

    implementation(libs.androidx.core.ktx)
    implementation("com.google.android.material:material:1.9.0")
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // OkHttp para requisições HTTP
    implementation (libs.okhttp)

    // Biblioteca Gson para serialização/deserialização JSON
    implementation(libs.gson)

    // Se você usa coroutines para requisições assíncronas
    implementation(libs.kotlinx.coroutines.android)

    // Outras dependências relevantes
    implementation(libs.androidx.appcompat.v161)
    implementation(libs.androidx.lifecycle.runtime.ktx)
}