import models.App
import utility.PATH_FILE_GOOGLE_PLAY_JSON
import utility.ReadFile


fun main() {

    // root init project
    val readFile = ReadFile()
    val file = readFile.readFile(PATH_FILE_GOOGLE_PLAY_JSON)
    val dataSource: List<App> = JSONParser().getAllApps(file)
    val analyzer = Analyzer()

    with(analyzer) {
        println(getOldestApp(dataSource))
        println(getLargestApps(dataSource, 5))

    }

    //your code here

    print(analyzer.countAppsDevelopedBySpecificCompany(dataSource,"Google LLC"))



}

