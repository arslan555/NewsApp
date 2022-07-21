object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

object Deps {
    val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    val lifecycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.compose}" }
    val composeUI by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composeTooling by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.material}" }
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    val extJUnit by lazy { "androidx.test.ext:junit:${Versions.extJUnit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    val composeJUnit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    val composeUITooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val composeUIManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }
}