import interfaces.DataSource
import models.App
import org.json.JSONArray
import org.json.JSONObject
import utility.extension.convertSizeToMegabyte
import utility.extension.convertStringToDateObject
import utility.extension.toRequiredAndroidVersion
import java.io.File

class JSONParser(): DataSource {

    private fun getGooglePlayAppsFromJSON(file: File): List<App> {

        val googlePlayApps = mutableListOf<App>()
        val jsonString = file.readText()
        JSONArray(jsonString).forEach {
            val jsonObject = JSONObject(it.toString())
            with(jsonObject) {
                googlePlayApps.add(
                    App(
                        name = getString("appName"),
                        company = getString("company"),
                        category = getString("category"),
                        updatedAt = getString("updated").convertStringToDateObject(),
                        size = getString("size").convertSizeToMegabyte(),
                        installsCount = getLong("installs"),
                        currentVersion = get("currentVersion").toString(),
                        requiresAndroid = getString("requiresAndroid").toRequiredAndroidVersion(),
                    )
                )
            }
            
        }

         return googlePlayApps
    }


    override fun getAllApps(file: File): List<App> {
        return getGooglePlayAppsFromJSON(file)
    }
}