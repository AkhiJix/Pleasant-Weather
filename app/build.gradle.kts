import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.compose.compiler)
}

fun getApiKey(): String {
    val properties = Properties()
    properties.load(rootProject.file("local.properties").inputStream())
    return properties.getProperty("API_KEY")
}


android {
    namespace = "com.akhijix.pleasantweather"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.akhijix.pleasantweather"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "API_KEY", "\"${getApiKey()}\"")
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
    buildFeatures {
        compose = true
        buildConfig = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    hilt {
        enableAggregatingTask = false
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.play.services.location)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.robolectric)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Dagger Hilt for dependency injection
    implementation(libs.dagger.hilt)
    ksp(libs.hilt.compiler)
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.navigation)
    implementation("com.squareup:javapoet:1.13.0")

    // Retrofit for network operations
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)

    // Accompanist permissions for handling permissions
    implementation(libs.accompanist.permissions)

    // Navigation component for Compose
    implementation(libs.navigation.compose)

    // Kotlin Serialization for JSON parsing
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.kotlin.reflect)
}