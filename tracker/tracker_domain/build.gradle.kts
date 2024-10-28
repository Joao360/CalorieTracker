plugins {
    id("base-module")
}

android {
    namespace = "com.joaograca.tracker_domain"
}

dependencies {
    implementation(project(":core"))
    implementation(libs.kotlinx.coroutines.core)
}