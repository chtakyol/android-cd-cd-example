plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.cihatakyol.androidcdcdexample"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.cihatakyol.androidcdcdexample"
        minSdk = 24
        targetSdk = 34
        versionCode = 4
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "BUILD_TYPE",
                "\"${android.defaultConfig.versionName}-(${android.defaultConfig.versionCode})\""
            )
        }

        debug {
            versionNameSuffix = "-debug"
            isMinifyEnabled = false
            buildConfigField(
                "String",
                "BUILD_TYPE",
                "\"$versionNameSuffix - ${android.defaultConfig.versionName}-(${android.defaultConfig.versionCode})\""
            )
        }

        create("staging") {
            versionNameSuffix = "-staging"
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "BUILD_TYPE",
                "\"$versionNameSuffix - ${android.defaultConfig.versionName}-(${android.defaultConfig.versionCode})\""
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}


tasks.register("printVersionName") {
    doLast {
        println(android.defaultConfig.versionName)
    }
}

tasks.register("printVersionCode") {
    doLast {
        println(android.defaultConfig.versionCode)
    }
}

tasks.register("printVersionSuffix") {
    doLast {
        val buildType = project.gradle.startParameter.taskNames.find { it.contains("assemble") }
            ?.replace("assemble", "")
            ?.lowercase() ?: "debug"

        val suffix = android.buildTypes.findByName(buildType)?.versionNameSuffix ?: ""
        println(suffix)
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}