plugins {
    id("compose-module")
}

android {
    namespace = "com.joaograca.onboarding_presentation"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":core-ui"))
    implementation(project(":onboarding:onboarding_domain"))
}