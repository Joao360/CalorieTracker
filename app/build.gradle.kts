plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.plcoding.calorytracker"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.plcoding.calorytracker.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            // proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        // useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("**/attach_hotspot_windows.dll")
        exclude("META-INF/licenses/ASM")
        /*resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }*/
    }
}

dependencies {
    implementation(libs.compose.compiler)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.compose.material)
    implementation(libs.compose.runtime)
    implementation(libs.navigation.compose)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.activity.compose)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    implementation(project(":core"))
    implementation(project(":core-ui"))
    implementation(project(":onboarding:onboarding_presentation"))
    implementation(project(":onboarding:onboarding_domain"))
    implementation(project(":tracker:tracker_presentation"))
    implementation(project(":tracker:tracker_domain"))
    implementation(project(":tracker:tracker_data"))

    implementation(libs.core.ktx)
    implementation(libs.app.compat)

    implementation(libs.coilCompose)

    implementation(libs.material)

    implementation(libs.okHttp)
    implementation(libs.retrofit)
    implementation(libs.okHttp.logging.interceptor)
    implementation(libs.retrofit.moshi.converter)

    kapt(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)

    testImplementation(libs.junit4)
    testImplementation(libs.junitAndroidExt)
    testImplementation(libs.truth)
    testImplementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.turbine)
    testImplementation(libs.composeUiTest)
    testImplementation(libs.mockk)
    testImplementation(libs.mockWebServer)

    androidTestImplementation(libs.junit4)
    androidTestImplementation(libs.junitAndroidExt)
    androidTestImplementation(libs.truth)
    androidTestImplementation(libs.kotlinx.coroutines.core)
    androidTestImplementation(libs.turbine)
    androidTestImplementation(libs.composeUiTest)
    androidTestImplementation(libs.mockk.android)
    androidTestImplementation(libs.mockWebServer)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.compiler)
    androidTestImplementation(libs.testRunner)
}