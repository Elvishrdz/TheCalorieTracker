import org.apache.tools.ant.taskdefs.condition.Os

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Android.applicationPlugin) version Android.applicationPluginVersion apply false
    id(Android.libraryPlugin) version Android.libraryPluginVersion apply false
    id(Kotlin.androidPlugin) version Kotlin.androidPluginVersion apply false
    id(Kotlin.jvmPlugin) version Kotlin.jvmPluginVersion apply false
    id(BenManes.dependencyUpdatesPlugin) version BenManes.dependencyUpdatesPluginVersion
    id(Ktlint.ktlintPlugin) version Ktlint.ktlintPluginVersion
}

buildscript {
    dependencies {
        classpath(Android.toolsBuildPlugin)
        classpath(DaggerHilt.hiltAndroidGradlePlugin)
        classpath(Kotlin.gradlePlugin)
    }
}

tasks.register("installGitHook", Copy::class) {
    val fileName = "pre-commit"

    val osFileName = if (Os.isFamily(Os.FAMILY_MAC)) {
        "$fileName-macos"
    } else if (Os.isFamily(Os.FAMILY_WINDOWS)) {
        "$fileName-windows"
    } else {
        fileName
    }

    from("${rootProject.rootDir}/scripts/$osFileName")
    into("${rootProject.rootDir}/.git/hooks")

    rename(osFileName, fileName)
}
