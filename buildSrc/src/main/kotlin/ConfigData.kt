object ConfigData {
    const val compileSdkVersion = 32
    const val minSdkVersion = 21
    const val targetSdkVersion = 32
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val testInstrumentRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val defaultProguardFileName = "proguard-android-optimize.txt"
    const val proguardRules = "proguard-rules.pro"
    const val consumerRules = "consumer-rules.pro"
    const val jvmTarget = "1.8"

    object Package {
        const val appPackage = "com.arslan.nytimesnewsapp"
        const val databasePackage = "com.arslan.database"
        const val datastorePackage = "com.arslan.datastore"
        const val networkPackage = "com.arslan.network"
        const val dataPackage = "com.arslan.data"
        const val resourcesPackage = "com.arslan.resources"
        const val utilsPackage = "com.arslan.utils"
        const val navigationPackage = "com.arslan.navigation"
        const val newsPackage = "com.arslan.news"
        const val homePackage = "com.arslan.home"
        const val explorePackage = "com.arslan.explore"
        const val bookmarkPackage = "com.arslan.bookmark"
        const val profilePackage = "com.arslan.profile"
        const val onBoardingPackage = "com.arslan.onboarding"
    }

    object ConfigField {
        const val baseUrl = "baseUrl"
        const val apiKey = "apiKey"
    }

}