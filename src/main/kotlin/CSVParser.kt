import interfaces.DataSource
import models.App
import utility.extension.convertSizeToMegabyte
import utility.GooglePlayCsvColumnIndex
import utility.extension.convertStringToDateObject
import utility.extension.toRequiredAndroidVersion
import java.io.File

class CSVParser(): DataSource {

    /**
     * convert data from csv file to @sample App model
     * @return List<App>
     */
    private fun getGooglePlayAppsFromCsv(file: File): List<App> {
        val googlePlayApps = mutableListOf<App>()
        file.forEachLine {
            val appData = it.split(",")
            googlePlayApps.add(
                App(
                    name = appData[GooglePlayCsvColumnIndex.NAME],
                    company = appData[GooglePlayCsvColumnIndex.COMPANY],
                    category = appData[GooglePlayCsvColumnIndex.CATEGORY],
                    updatedAt = appData[GooglePlayCsvColumnIndex.UPDATED_AT].convertStringToDateObject(),
                    size = appData[GooglePlayCsvColumnIndex.SIZE].convertSizeToMegabyte(),
                    installsCount = appData[GooglePlayCsvColumnIndex.INSTALLS_COUNT].toLong(),
                    currentVersion = appData[GooglePlayCsvColumnIndex.CURRENT_VERSION],
                    requiresAndroid = appData[GooglePlayCsvColumnIndex.REQUIRES_ANDROID].toRequiredAndroidVersion(),
                )
            )
        }
        return  googlePlayApps
    }

    override fun getAllApps(file: File): List<App> {
        return getGooglePlayAppsFromCsv(file)
    }
}