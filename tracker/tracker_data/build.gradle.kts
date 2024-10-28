plugins {
    id("base-module")
    id("com.google.devtools.ksp")
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

    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
}