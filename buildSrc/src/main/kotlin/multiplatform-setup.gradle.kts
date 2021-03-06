import gradle.kotlin.dsl.accessors._2e23d8fadf0ed92ae13e19db3d83f86d.compose
import gradle.kotlin.dsl.accessors._2e23d8fadf0ed92ae13e19db3d83f86d.kotlin
import gradle.kotlin.dsl.accessors._2e23d8fadf0ed92ae13e19db3d83f86d.sourceSets
import org.gradle.kotlin.dsl.withType

plugins {
    id("com.android.library")
    id("kotlin-multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm("desktop")
    android()
    js {
        browser()
        nodejs()
    }
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
            }
        }

        named("androidMain") {
            dependencies {
                implementation("androidx.appcompat:appcompat:1.2.0")
                implementation(Androidx.core)
            }
        }

        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.common)
            }
        }
        named("jsMain") {
            dependencies {
                implementation("org.jetbrains:kotlin-react:17.0.1-pre.148-kotlin-1.4.30")
                implementation("org.jetbrains:kotlin-styled:1.0.0-pre.115-kotlin-1.4.10")
                implementation("org.jetbrains:kotlin-react-dom:17.0.1-pre.148-kotlin-1.4.30")
            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}