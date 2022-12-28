import org.apache.tools.ant.taskdefs.condition.Os

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version Kotlin.version apply false
    id("org.jetbrains.kotlin.jvm") version Kotlin.version apply false
    id("com.github.ben-manes.versions") version BenManes.version
    id("org.jlleitschuh.gradle.ktlint") version Ktlint.version
}

buildscript {
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Build.kotlinGradlePlugin)
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
