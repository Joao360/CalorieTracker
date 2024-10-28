plugins {
    id("compose-module")
}

android {
    namespace = "com.joaograca.tracker_presentation"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":core-ui"))
    implementation(project(":tracker:tracker_domain"))

    implementation(libs.coilCompose)
}