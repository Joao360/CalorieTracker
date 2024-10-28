plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-beta02"
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    coreLibraryDesugaring(libs.findLibrary("desugar").get())

    implementation(libs.findLibrary("compose.compiler").get())
    implementation(libs.findLibrary("compose.ui").get())
    implementation(libs.findLibrary("compose.ui.tooling.preview").get())
    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("compose.material").get())
    implementation(libs.findLibrary("compose.runtime").get())
    implementation(libs.findLibrary("navigation.compose").get())
    implementation(libs.findLibrary("lifecycle.viewmodel.compose").get())
    implementation(libs.findLibrary("activity.compose").get())

    kapt(libs.findLibrary("hilt.compiler").get())
    implementation(libs.findLibrary("hilt").get())

    testImplementation(libs.findLibrary("junit4").get())
    testImplementation(libs.findLibrary("junitAndroidExt").get())
    testImplementation(libs.findLibrary("truth").get())
    testImplementation(libs.findLibrary("coroutines.test").get())
    testImplementation(libs.findLibrary("turbine").get())
    testImplementation(libs.findLibrary("composeUiTest").get())
    testImplementation(libs.findLibrary("mockk").get())
    testImplementation(libs.findLibrary("mockWebServer").get())

    androidTestImplementation(libs.findLibrary("junit4").get())
    androidTestImplementation(libs.findLibrary("junitAndroidExt").get())
    androidTestImplementation(libs.findLibrary("truth").get())
    androidTestImplementation(libs.findLibrary("coroutines.test").get())
    androidTestImplementation(libs.findLibrary("turbine").get())
    androidTestImplementation(libs.findLibrary("composeUiTest").get())
    androidTestImplementation(libs.findLibrary("mockk").get())
    androidTestImplementation(libs.findLibrary("mockWebServer").get())
    androidTestImplementation(libs.findLibrary("hilt.android.testing").get())
}