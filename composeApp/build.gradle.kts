defaultConfig {
        applicationId = "com.corven.music"
        minSdk = 21
        targetSdk = 35
        versionCode = 92
        versionName = "1.0.Corven"

        // Esta línea es la que suele fallar, la puse más limpia:
        resValue("string", "env_name", "CorvenMusic")
    }
