plugins {
    id(Plugin.library)
    id(Plugin.kotlinAndroid)
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = ConfigData.Package.homePackage
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = ConfigData.testInstrumentRunner
        consumerProguardFiles(ConfigData.consumerRules)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ConfigData.defaultProguardFileName),
                ConfigData.proguardRules
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(Deps.core)
    implementation(Deps.appCompat)

    implementation(project(Deps.Modules.path to Deps.Modules.Common.resources))
    implementation(project(Deps.Modules.path to Deps.Modules.Common.utils))
    implementation(project(Deps.Modules.path to Deps.Modules.Common.network))
    implementation(project(mapOf(Deps.Modules.path to Deps.Modules.Common.data)))
    implementation(Deps.Retrofit.gsonConverter)

    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    testImplementation(Deps.Tests.jUnit)
    androidTestImplementation(Deps.AndroidTest.extJUnit)
    androidTestImplementation(Deps.AndroidTest.espresso)
}