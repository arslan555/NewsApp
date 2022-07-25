buildscript {

    dependencies {
        classpath(Gradle.daggerHilt)
    }

}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugin.application).version(Version.gradlePlugin).apply(false)
    id(Plugin.library).version(Version.gradlePlugin).apply(false)
    id(Plugin.kotlinAndroid).version(Version.kotlin).apply(false)
}