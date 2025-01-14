import interfaces.DataSource
import models.App
import utility.GooglePlayCsvColumnIndex
import utility.extension.toMegabyte
import utility.extension.toDateObject
import utility.extension.toRequiredAndroidVersion
import java.io.File

class CSVParser : DataSource {

    /**
     * convert data from csv file to @sample App model
     * @return List<App>
     */
    private fun getGooglePlayAppsFromCSV(file: File): List<App> {
        val googlePlayApps = mutableListOf<App>()
        file.forEachLine {
            val appData = it.split(",")
            with(GooglePlayCsvColumnIndex) {
                googlePlayApps.add(
                    App(
                        name = appData[NAME],
                        company = appData[COMPANY],
                        category = appData[CATEGORY],
                        updatedAt = appData[UPDATED_AT].toDateObject(),
                        size = appData[SIZE].toMegabyte(),
                        installsCount = appData[INSTALLS_COUNT].toLong(),
                        currentVersion = appData[CURRENT_VERSION],
                        requiresAndroid = appData[REQUIRES_ANDROID].toRequiredAndroidVersion(),
                    )
                )
            }
        }
        return googlePlayApps
    }

    override fun getAllApps(file: File): List<App> {
        return getGooglePlayAppsFromCSV(file)
    }
}