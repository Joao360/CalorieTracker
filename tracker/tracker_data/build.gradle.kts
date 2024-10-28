plugins {
    id("base-module")
}

android {
    namespace = "com.joaograca.tracker_data"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":tracker:tracker_domain"))

    implementation(libs.okHttp)
    implementation(libs.retrofit)
    implementation(libs.okHttp.logging.interceptor)
    implementation(libs.retrofit.moshi.converter)

    kapt(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
}