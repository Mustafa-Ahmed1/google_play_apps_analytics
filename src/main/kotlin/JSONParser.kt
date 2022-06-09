import interfaces.DataSource
import models.App
import org.json.JSONArray
import org.json.JSONObject
import utility.extension.convertStringToDateObject
import utility.extension.toRequiredAndroidVersion
import java.io.File

class JSONParser(): DataSource {

    private fun getGooglePlayAppsFromJSON(file: File): List<App> {

        val googlePlayApps = mutableListOf<App>()
        val jsonString = file.readText()
        val jsonArray = JSONArray(jsonString).forEach {
            val jsonObject = JSONObject(it.toString())
            googlePlayApps.add(
                App(
                    name = jsonObject.getString("appName"),
                    company = jsonObject.getString("company"),
                    category = jsonObject.getString("category"),
                    updatedAt = jsonObject.getString("updated").convertStringToDateObject(),
                    size = jsonObject.getString("size").toRequiredAndroidVersion()!!,
                    installsCount = jsonObject.getInt("installs").toLong(),
                    currentVersion = jsonObject.getString("currentVersion"),
                    requiresAndroid = jsonObject.getString("requiresAndroid").toRequiredAndroidVersion(),
                )
            )
        }

         return googlePlayApps
    }


    override fun getAllApps(file: File): List<App> {
        return getGooglePlayAppsFromJSON(file)
    }
}