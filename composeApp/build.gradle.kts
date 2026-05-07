// ... (mantené los plugins y configuraciones iniciales igual hasta llegar a la sección 'android')

android {
    // ... (mantené tus funciones de propertyOrEmpty)

    defaultConfig {
        applicationId = "com.corven.music" // El nuevo DNI de tu app
        minSdk = 21
        targetSdk = 35
        versionCode = 90 // Aumentado para que el celu lo vea como nuevo
        versionName = "1.0.Corven" // Tu versión inicial
        
        // ... (mantené todo lo de INIT ENVIRONMENT igual)
    }

    // ... (mantené splits y namespace igual)

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            manifestPlaceholders["appName"] = "CorvenMusic-Debug"
        }

        release {
            vcsInfo.include = false
            isMinifyEnabled = true
            isShrinkResources = true
            manifestPlaceholders["appName"] = "CorvenMusic" // AQUÍ CAMBIAMOS EL NOMBRE
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    applicationVariants.all {
        val variant = this
        variant.outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                val outputFileName = "corvenmusic-${variant.baseName}.apk" // NOMBRE DEL ARCHIVO GENERADO
                output.outputFileName = outputFileName
            }
    }

    flavorDimensions += "version"
    productFlavors {
        create("full") {
            dimension = "version"
            manifestPlaceholders["appName"] = "CorvenMusic" // NOMBRE PARA LA VERSIÓN FULL
        }
        create("accrescent") {
            dimension = "version"
            manifestPlaceholders["appName"] = "CorvenMusic-Acc" // NOMBRE PARA LA VERSIÓN ACC
        }
    }
    
    // ... (seguí con el resto del archivo igual)
}
