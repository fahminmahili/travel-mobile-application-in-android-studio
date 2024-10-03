plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.fegetravelmobileapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fegetravelmobileapp"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


    implementation ("com.google.android.gms:play-services-maps:17.0.1")  // Google Maps
    implementation ("com.google.android.gms:play-services-location:18.0.0")  // Location services
    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation ("com.google.maps.android:android-maps-utils:2.2.5")
//    implementation ("com.google.android.libraries.places:places:2.4.0")
    implementation ("com.google.maps:google-maps-services:0.18.0")


    implementation ("com.google.android.material:material:1.6.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")


}
