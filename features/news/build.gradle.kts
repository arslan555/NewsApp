plugins {
    id(Plugin.library)
    id(Plugin.kotlinAndroid)
    kotlin(Plugin.kapt)
    id(Plugin.daggerHilt)
}

android {
    namespace = ConfigData.Package.newsPackage
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

    implementation(project(Deps.Modules.path to Deps.Modules.Feature.home))
    implementation(project(Deps.Modules.path to Deps.Modules.Feature.explore))
    implementation(project(Deps.Modules.path to Deps.Modules.Feature.bookmark))
    implementation(project(Deps.Modules.path to Deps.Modules.Feature.profile))

    implementation(Deps.DaggerHilt.core)
    kapt(Deps.DaggerHilt.compiler)

    testImplementation(Deps.Tests.jUnit)
    androidTestImplementation(Deps.AndroidTest.extJUnit)
    androidTestImplementation(Deps.AndroidTest.espresso)
}