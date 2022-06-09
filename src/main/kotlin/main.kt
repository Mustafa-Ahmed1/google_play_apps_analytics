import models.App
import utility.PATH_FILE_GOOGLE_PLAY_CSV
import utility.ReadCSV
import utility.extension.convertSizeToMegabyte


fun main() {

    // root init project
    val readCSV = ReadCSV()
    val file = readCSV.readCSV("assets/google_play.json")
    val dataSource: List<App> = JSONParser().getAllApps(file)
    val analyzer = Analyzer()

    with(analyzer) {
        println(getOldestApp(dataSource))
        println(getLargestApps(dataSource, 5))

    }

    //your code here

    print(analyzer.countAppsDevelopedBySpecificCompany(dataSource,"google"))



}

