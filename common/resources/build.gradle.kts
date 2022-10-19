plugins {
    id(Plugin.library)
    id(Plugin.kotlinAndroid)
    id(Plugin.daggerHilt)
    kotlin(Plugin.kapt)
}

android {
    namespace = ConfigData.Package.resourcesPackage
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
}

dependencies {

    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.DaggerHilt.core)
    api(Deps.Compose.activity)
    api(Deps.Compose.ui)
    api(Deps.Compose.navigation)
    api(Deps.Compose.material)
    api(Deps.Compose.constraintLayout)
    debugApi(Deps.Compose.tooling)
    api(Deps.Compose.toolingPreview)
    kapt(Deps.DaggerHilt.compiler)
    testImplementation(Deps.Tests.jUnit)
    androidTestImplementation(Deps.AndroidTest.extJUnit)
    androidTestImplementation(Deps.AndroidTest.espresso)
}