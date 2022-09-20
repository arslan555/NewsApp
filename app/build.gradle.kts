plugins {
    id(Plugin.application)
    id(Plugin.kotlinAndroid)
    id(Plugin.daggerHilt)
    kotlin(Plugin.kapt)
}

android {
    namespace = ConfigData.Package.appPackage
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.Package.appPackage
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = ConfigData.testInstrumentRunner
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }

}

dependencies {

    implementation(Deps.core)
    implementation(Deps.lifecycle)
    implementation(Deps.Compose.composeActivity)
    implementation(Deps.Compose.composeUI)
    implementation(Deps.Compose.composeToolingPreview)
    implementation(Deps.Compose.composeMaterial)
    implementation(Deps.Retrofit.gsonConverter)
    implementation(Deps.Timber.log)
    implementation(Deps.DaggerHilt.core)
    kapt(Deps.DaggerHilt.compiler)

    implementation(project(Deps.Modules.path to Deps.Modules.Common.database))
    implementation(project(Deps.Modules.path to Deps.Modules.Common.datastore))
    implementation(project(Deps.Modules.path to Deps.Modules.Common.network))
    implementation(project(Deps.Modules.path to Deps.Modules.Common.resources))
    implementation(project(Deps.Modules.path to Deps.Modules.Common.utils))

    implementation(project(Deps.Modules.path to Deps.Modules.Feature.news))
    implementation(project(Deps.Modules.path to Deps.Modules.Feature.newsDetails))
    implementation(project(Deps.Modules.path to Deps.Modules.Feature.onboarding))

    implementation(project(Deps.Modules.path to Deps.Modules.navigation))

    testImplementation(Deps.Tests.jUnit)

    androidTestImplementation(Deps.AndroidTest.extJUnit)
    androidTestImplementation(Deps.AndroidTest.espresso)
    androidTestImplementation(Deps.AndroidTest.composeJUnit)

}