import models.App
import kotlin.math.round

class Analyzer {

    fun countAppsDevelopedBySpecificCompany(apps:List<App>,companyName:String): Int {
        return if ( apps.isNotEmpty() && companyName.isNotEmpty() ){
            apps.count { it.company.contains(companyName.trim()) }
        }
        else{
            -1
        }
    }

    fun  findPercentageOfSpecificApp(apps: List<App>,appType:String): Double {
        val countSpecificApp = apps.count { it.category.lowercase() == appType.lowercase().trim() }

        return if ( apps.isEmpty() && appType.isEmpty() ) -1.0
               else round( countSpecificApp.toDouble() / apps.size * 100)
    }

    /**
     * @return OldestApp in model app
     * @param apps<App>
     *
     */
    fun  getOldestApp(apps:List<App>): App? {
        return if(apps.isNotEmpty()) {
            apps.minByOrNull { it.updatedAt }
        } else null
    }

    fun  calculatePercentageOfAppsRunningOnSpecificVersion(apps:List<App>,version:Double):Double{
        var counter = 0.0
        return if (apps.isNotEmpty()){
            apps.forEach{
                if(it.requiresAndroid==version)
                    counter++
            }
            round( counter / apps.size * 100)
        } else -1.0
    }

    /**
     * function @return [App] developed by Specific Company
     * @param listApps and  companyName is required
     */

    fun getLargestAppByCompany(listApps: List<App>, companyName: String): App? {
        return if(listApps.isNotEmpty()  && !companyName.isNullOrBlank()){
             val companyApp: List<App> = listApps.filter {
                 it.company.lowercase().contains(companyName.lowercase().trim())
             }
             getLargestApps(companyApp, 1).firstOrNull()
        }else null
    }

    fun  getLargestApps(apps:List<App>,n:Int):List<App> = apps.sortedByDescending { it.size }.take(n)

    fun  getTopInstalledApps(apps: List<App>,top:Int):List<App>{
        if (apps.isEmpty() || apps.all { it.installsCount < 0 } || top <=0){
            return emptyList()
        }
        return apps.sortedByDescending { it.installsCount}.take(top)
    }

}
