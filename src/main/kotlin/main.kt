import models.App
import utility.*

fun main() {

    val readFile = ReadFile()
    val file = readFile.readFile(FilePath.GOOGLE_PLAY_JSON)

    val apps: List<App> = JSONParser().getAllApps(file)

    with(Analyzer()) {
        println("Number of Apps Developed by Google: " +
            {countAppsDevelopedBySpecificCompany(apps, "Google")})
        println("\nPercentage of medical apps: " +
                findPercentageOfSpecificApp(apps, "Medical"))
        println("\nOldest apps: " +
                getOldestApp(apps))
        println("\nPercentage of apps running on Android 9.0: " +
                calculatePercentageOfAppsRunningOnSpecificVersion(apps, 9.0))
        println("\nLargest app developed by Google: " +
                getLargestAppByCompany(apps, "Google"))
        println("\nLargest five apps: " +
                getLargestApps(apps, 5))
        println("\nTop 10 installed apps: " +
                getTopInstalledApps(apps, 5))
    }

}
