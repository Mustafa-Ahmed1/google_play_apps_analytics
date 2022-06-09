import models.App
import utility.ReadFile


fun main() {

    // root init project
    val readFile = ReadFile()
    val file = readFile.readFile("assets/google_play.json")
    val dataSource: List<App> = JSONParser().getAllApps(file)
    val analyzer = Analyzer()

    with(analyzer) {
        println(getOldestApp(dataSource))
        println(getLargestApps(dataSource, 5))

    }

    //your code here

    print(analyzer.countAppsDevelopedBySpecificCompany(dataSource,"Google LLC"))



}

