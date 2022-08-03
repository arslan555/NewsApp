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

        buildConfigField("String", ConfigData.ConfigField.baseUrl, getBaseUrl())
        buildConfigField("String", ConfigData.ConfigField.apiKey, getApiKey())
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
    implementation(Deps.Timber.log)

    testImplementation(Deps.Tests.jUnit)
    androidTestImplementation(Deps.AndroidTest.extJUnit)
    androidTestImplementation(Deps.AndroidTest.espresso)
}

fun getBaseUrl(): String = readProperties()[ConfigData.ConfigField.baseUrl] ?: ""

fun getApiKey(): String = readProperties()[ConfigData.ConfigField.apiKey] ?: ""

fun readProperties(fileName: String = "keys.properties"): HashMap<String, String> {
    val items by lazy { HashMap<String, String>() }
    val fl = rootProject.file(fileName)
    (fl.exists()).let {
        fl.forEachLine {
            items[it.split("=")[0]] = it.split("=")[1]
        }
    }
    return items
}