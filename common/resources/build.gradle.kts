plugins {
    id(Plugin.library)
    id(Plugin.kotlinAndroid)
    kotlin(Plugin.kapt)
    id(Plugin.daggerHilt)
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

    api(Deps.Compose.hilt)
    api(Deps.Compose.lifecycle)
    api(Deps.Compose.runtimeCompose)
    api(Deps.Compose.compilerCompose)
    api(Deps.Compose.uiTooling)
    api(Deps.Compose.navigation)
    implementation("io.coil-kt:coil-compose:2.1.0")
    implementation(Deps.DaggerHilt.core)
    kapt(Deps.DaggerHilt.compiler)

    api(project(mapOf(Deps.Modules.path to Deps.Modules.Common.model)))
    api(project(mapOf(Deps.Modules.path to Deps.Modules.Common.utils)))

    api(Deps.Compose.activity)
    api(Deps.Compose.ui)
    api(Deps.Compose.material)
    api(Deps.Compose.constraintLayout)
    debugApi(Deps.Compose.tooling)
    api(Deps.Compose.toolingPreview)
    testImplementation(Deps.Tests.jUnit)
    androidTestImplementation(Deps.AndroidTest.extJUnit)
    androidTestImplementation(Deps.AndroidTest.espresso)
}