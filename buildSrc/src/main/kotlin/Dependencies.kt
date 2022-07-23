object Gradle {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

object Plugins {
    val application by lazy { "com.android.application" }
    val library by lazy { "com.android.library" }
    val android by lazy { "android" }
    val kotlinAndroid by lazy { "org.jetbrains.kotlin.android" }
}

object Deps {
    val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    val lifecycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }

    object Modules{
        const val path = "path"
        const val database = ":common:database"
        const val datastore = ":common:datastore"
        const val network = ":common:network"
        const val resources = ":common:resources"
        const val utils = ":common:utils"
    }
    object Compose {
        val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
        val composeUI by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
        val composeTooling by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
        val composeMaterial by lazy { "androidx.compose.material:material:${Versions.composeMaterial}" }
    }

    object Tests {
        val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    }

    object AndroidTest {
        val extJUnit by lazy { "androidx.test.ext:junit:${Versions.extJUnit}" }
        val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
        val composeJUnit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    }


}