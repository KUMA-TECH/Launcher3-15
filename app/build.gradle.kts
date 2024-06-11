import com.google.protobuf.gradle.proto

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.protobuf)
}
android {
    namespace = "com.android.launcher3"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.launcher3"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    flavorDimensions += listOf("app", "recents")
    productFlavors {
        create("aosp") {
            dimension = "app"
            applicationId = "com.km.launcher3"
            testApplicationId = "com.android.launcher3.tests"
        }

        create("l3go") {
            dimension = "app"
            applicationId = "com.km.launcher3"
            testApplicationId = "com.android.launcher3.tests"
        }

        create("withQuickstep") {
            dimension = "recents"
            minSdk = 28
        }

        create("withoutQuickstep") {
            dimension = "recents"
            applicationId = "com.km.launcher3"
        }
    }

    sourceSets.apply {
        getByName("main") {
            java.setSrcDirs(listOf("src/main/java","src_plugins", "src_build_config", "tests/shared"))
            manifest.srcFile("src/main/AndroidManifest-common.xml")
            proto {
                setSrcDirs(listOf("protos/", "protos_overrides/"))
            }
        }
//        getByName("androidTest") {
//            res.srcDirs(listOf("tests/res"))
//            java.setSrcDirs(listOf("tests/src", "tests/tapl"))
//            manifest.srcFile("tests/AndroidManifest.xml")
//        }
//        getByName("androidTestDebug") {
//            manifest.srcFile("tests/AndroidManifest.xml")
//        }

        getByName("aosp") {
            java.setSrcDirs(listOf("src_shortcuts_overrides"))
        }

        getByName("l3go") {
            java.setSrcDirs(listOf("go/src"))
            res.srcDirs("go/res")
            manifest.srcFile("go/AndroidManifest.xml")
        }

        getByName("withoutQuickstep") {
            java.setSrcDirs(listOf("src_ui_overrides"))
        }

//        getByName("withQuickstep") {
//            res.srcDirs(listOf("quickstep/res", "quickstep/recents_ui_overrides/res"))
//            java.setSrcDirs(listOf("quickstep/src", "quickstep/recents_ui_overrides/src"))
//            manifest.srcFile("quickstep/AndroidManifest.xml")
//        }
//
//        getByName("l3goWithoutQuickstepDebug") {
//            manifest.srcFile("AndroidManifest.xml")
//        }
//
//        getByName("l3goWithQuickstepDebug") {
//            manifest.srcFile("quickstep/AndroidManifest-launcher.xml")
//        }
//
//
//        getByName("aospWithoutQuickstep") {
//            manifest.srcFile("AndroidManifest.xml")
//        }
//
//        getByName("aospWithQuickstep") {
//            manifest.srcFile("quickstep/AndroidManifest-launcher.xml")
//        }
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

//    implementation(libs.androidx.dynamicanimation.ktx)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.preference)
    implementation(libs.protobuf.java)
    implementation(libs.protoc)
    implementation(libs.slice.core)
    implementation(libs.androidx.annotation)

    implementation(project(":IconLoader"))
    implementation(project(":AnimationLib"))
    implementation(project(":SystemUI"))
//    implementation (project(":UiTestsLibLauncher"))
//    withQuickstepImplementation ((project(':SharedLibWrapper')))

    // Recents lib dependency
//    withQuickstepImplementation ((fileTree(dir: "${FRAMEWORK_PREBUILTS_DIR}/quickstep/libs", include: 'sysui_shared.jar')))

    // Required for AOSP to compile. This is already included in the sysui_shared.jar
//    withoutQuickstepImplementation ((fileTree(dir: "${FRAMEWORK_PREBUILTS_DIR}/libs", include: 'plugin_core.jar')))
//
//    testImplementation (libs.mockitoInlineExtended)
//    androidTestImplementation (libs.mockitoInlineExtended)
//    androidTestImplementation (libs.mockito.core)
    androidTestImplementation(libs.dexmaker)
    androidTestImplementation(libs.dexmaker.mockito)
    androidTestImplementation(libs.runner)
    androidTestImplementation(libs.rules)
    androidTestImplementation(libs.uiautomator.v18)
    androidTestImplementation(libs.androidx.annotation)

    api(libs.lottie)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

protobuf {
    // Configure the protoc executable
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.9"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins{
//                create("kotlin")
                create("java")
            }
        }
    }
}
