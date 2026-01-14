
plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

kotlin {
    sourceSets {
        main {
            kotlin.srcDirs("src/main/kotlin")
        }
    }
}


dependencies {
    // Thư viện này chứa androidx.compose.ui.window.window và application
    implementation(compose.desktop.currentOs)

    // Nếu bạn muốn dùng thêm các component Material3 của AndroidX/Compose
    implementation(compose.material3)
}

compose.desktop {
    application {
        mainClass = "pixelcell.MainKt"// Tên file chứa hàm main của bạn
        nativeDistributions {
            targetFormats(org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg, org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi, org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb)
            packageName = "PixelCell"
            packageVersion = "1.0.0"
        }
    }
}
