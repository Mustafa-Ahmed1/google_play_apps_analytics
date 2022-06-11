import models.App
import utility.*

fun main() {

    val readFile = ReadFile()
    val file = readFile.readFile(FilePath.GOOGLE_PLAY_JSON)

    val dataSource: List<App> = JSONParser().getAllApps(file)

    with(Analyzer()) {
        println("Number of Apps Developed by Google: " +
            {countAppsDevelopedBySpecificCompany(dataSource, "Google")})
        println("\nPercentage of medical apps: " +
                findPercentageOfSpecificApp(dataSource, "Medical"))
        println("\nOldest apps: " +
                getOldestApp(dataSource))
        println("\nPercentage of apps running on Android 9.0: " +
                calculatePercentageOfAppsRunningOnSpecificVersion(dataSource, 9.0))
        println("\nLargest app developed by Google: " +
                getLargestAppByCompany(dataSource, "Google"))
        println("\nLargest five apps: " +
                getLargestApps(dataSource, 5))
        println("\nTop 10 installed apps: " +
                getTopInstalledApps(dataSource, 5))
    }

}

