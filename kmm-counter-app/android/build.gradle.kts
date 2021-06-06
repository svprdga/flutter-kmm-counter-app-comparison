plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))

    implementation("com.google.android.material:material:1.3.0")

    // Compose
    implementation("androidx.compose.ui:ui:1.0.0-beta08")
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta08")
    implementation("androidx.compose.foundation:foundation:1.0.0-beta08")
    implementation("androidx.compose.material:material:1.0.0-beta08")
    implementation("androidx.compose.material:material-icons-core:1.0.0-beta08")
    implementation("androidx.compose.material:material-icons-extended:1.0.0-beta08")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta08")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.0.0-beta08")
    implementation("androidx.activity:activity-compose:1.3.0-alpha08")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.svprdga.flutterkmmcomparisonkmm.android"
        minSdkVersion(22)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    composeOptions {
        kotlinCompilerVersion = "1.5.10"
        kotlinCompilerExtensionVersion = "1.0.0-beta08"
    }
}