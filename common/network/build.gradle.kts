plugins {
    id(Plugin.library)
    id(Plugin.kotlinAndroid)
    id(Plugin.daggerHilt)
    kotlin(Plugin.kapt)
}

android {
    namespace = ConfigData.Package.networkPackage
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = ConfigData.testInstrumentRunner
        consumerProguardFiles(ConfigData.consumerRules)

        buildConfigField("String",ConfigData.ConfigField.baseUrl.first,ConfigData.ConfigField.baseUrl.second)
        buildConfigField("String",ConfigData.ConfigField.apiKey.first,ConfigData.ConfigField.apiKey.second)
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
}

dependencies {

    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.DaggerHilt.core)
    kapt(Deps.DaggerHilt.compiler)
    implementation(Deps.Retrofit.core)
    implementation(Deps.Retrofit.gsonConverter)
    implementation(Deps.OkHttp.logging)
    testImplementation(Deps.Tests.jUnit)
    androidTestImplementation(Deps.AndroidTest.extJUnit)
    androidTestImplementation(Deps.AndroidTest.espresso)
}