import models.App
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test
import utility.extension.convertSizeToUniqueUnit
import utility.extension.convertStringToDateObject
import kotlin.test.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    private lateinit var fakeApps :List<App>
    private lateinit var analyzer: Analyzer

    @BeforeAll
    fun setup() {
        analyzer = Analyzer()
    }

    @BeforeEach
    fun initial(){
        fakeApps = FakeData().fakeApps
    }


    /**
     * test function countAppsDevelopedBySpecificCompany()
     */
    @Test
    fun should_ReturnTheCountOfAppsDevelopedBySpecificCompany_when_CompanyNameIsValid(){
        //given
        //when calculate the app that developed by specific company with a valid name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"Google")
        //then find the result
        assertEquals(5,result)
    }

    @Test
    fun should_ReturnMinusOne_when_CountAppsDevelopedByBlankStringCompanyName(){
        //given
        //when count the app that developed by specific company with a blank company name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"")
        //then find the result
        assertEquals(-1,result)
    }

    @Test
    fun should_ReturnZero_when_CountTheCompanyNameSeparatedBySpace(){
        //given
        //when count the app that developed by specific company with a space in the middle
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"Goo gle")
        //then find the result
        assertEquals(0,result)
    }

    @Test
    fun should_ReturnTheCountOfAppDevelopedBySpecificCompany_when_CompanyNameContainSpaceAtTheEnd(){
        //given
        //when count the app that developed by specific company with a space at the end
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps," Google ")
        //then find the result
        assertEquals(5,result)
    }

    @Test
    fun should_ReturnZero_when_CountAppsDevelopedBySpecificNotValidCompanyName(){
        //given
        //when count the app that developed by specific company with not valid company name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"AliZainy")
        //then find the result
        assertEquals(0,result)
    }

    @Test
    fun should_ReturnZero_when_CountAppsDevelopedBySpecificUpperCaseCompanyName(){
        //given
        //when count the app that developed by specific company with upper case company name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"GOOGLE")
        //then find the result
        assertEquals(0,result)
    }

    /**
     * test function findPercentageOfSpecificApp()
     */
    @Test
    fun should_ReturnPercentageAppsOfSpecificCategory_when_CategoryNameIsValid(){
        //given
        //when calculate the percentage of valid category name
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"Medical")
        //then find the result
        assertEquals(25.0,result)
    }
    @Test
    fun should_ReturnZero_when_calculateThePercentageOfNotValidCategoryName(){
        // when calculate the percentage of Not valid category name
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"AliZainy")
        //then find the result
        assertEquals(0.0,result)
    }

    @Test
    fun should_ReturnZero_when_CategoryIsBlankString(){
        //when calculate empty category
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"")
        //then find the result
        assertEquals(0.0,result)
    }

    @Test
    fun should_ReturnPercentageAppsOfSpecificCategory_when_CategoryIsUpperOrLowerCase(){
        //when calculate the percentage of category name with upper or lower case
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"MEDICAL")
        //then find the result
        assertEquals(25.0,result)
    }

    @Test
    fun should_ReturnPercentageAppsOfSpecificCategory_when_CategoryNameWithSpaces(){
        //when calculate the percentage of category name with spaces
        val result = analyzer.findPercentageOfSpecificApp(fakeApps," Medical ")
        //then find the result
        assertEquals(25.0,result)
    }
    @Test
    fun should_ReturnNan_when_ListOfFakeAppsIsEmpty(){
        //given
        fakeApps= listOf()
        //when calculate the percentage of category name
        val result = analyzer.findPercentageOfSpecificApp(fakeApps," Medical ")
        //then find the result
        assertEquals(Double.NaN,result)
    }

    /**
     * test  function getOldestApp()
     */
    @Test
    fun should_ReturnNull_when_list_isEmpty(){
        //give set fakeApps is empty
        fakeApps= listOf()
        //when Oldest App
        val result = analyzer.getOldestApp(fakeApps)
        //then find the result
        assertNull(result)
    }
    @Test
    fun should_ReturnApp_when_list_isNotEmpty(){
        //when list not empty Oldest App
        val result = analyzer.getOldestApp(fakeApps)
        //then find the result
        assertNotNull(result)
    }
    @Test
    fun should_ReturnApp_when_list_isCorrect(){

        //when list oldest App correct
        val result = analyzer.getOldestApp(fakeApps)
        //then find the result
        var exception: App = App(
            name = "App 2",
            company = "Google LLC",
            category = "Medical",
            updatedAt = "September 26 2017".convertStringToDateObject(),
            size = "22M".convertSizeToUniqueUnit(),
            installsCount = 100000,
            currentVersion = "1.4.4-0e73d19a",
            requiresAndroid = 7.0,
        )
        assertEquals(exception,result)
    }



    /**
     * test function calculatePercentageOfAppsRunningOnSpecificVersion()
     */
    @Test
    fun should_ReturnPercentageOfAppsRunningOnSpecificVersion_when_VersionIsValid(){
        //when calculate the percentage of apps running on specific valid version
        val result = analyzer.calculatePercentageOfAppsRunningOnSpecificVersion(fakeApps,9.0)
        //then find the result
        assertEquals(10.0, result)
    }

    @Test
    fun should_ReturnZero_when_CalculatePercentageOfAppsRunningOnNotValidVersion(){
        //when calculate percentage of apps running on not valid version
        val result = analyzer.calculatePercentageOfAppsRunningOnSpecificVersion(fakeApps, 2.1)
        //then find the result
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnMinusOne_when_CalculatePercentageOfAppsRunningOnSpecificVersion_UsingEmptyList(){

        fakeApps= listOf()
        //when calculate percentage of apps using empty list
        val result = analyzer.calculatePercentageOfAppsRunningOnSpecificVersion(fakeApps, 9.0)
        //then find the result
        assertEquals(-1.0, result)
    }

    /**
     *
     * test function getTopInstalledApps()
     */
    @Test
    fun should_ReturnTopAppInstall_When_ItHasValidData() {
        //given fake data from our class FakeData as list call fakeApps
        val appList =  fakeApps
        //when search for top 3 apps installed
        val result = analyzer.getTopInstalledApps(apps = appList, top = 3)
        //then should return that order of top 3 installed apps
        val topThreeApps = listOf(
            App(
                name = "App 7",
                company = "WhatsApp LLC",
                category = "Communication",
                updatedAt = "May 9 2022".convertStringToDateObject(),
                size = "800M".convertSizeToUniqueUnit(),
                installsCount = 5000000000,
                currentVersion = "2.22.10.73",
                requiresAndroid = 4.1,
            ),
            App(
                name = "App 17",
                company = "WhatsApp LLC",
                category = "Communication",
                updatedAt = "May 9 2022".convertStringToDateObject(),
                size = "800M".convertSizeToUniqueUnit(),
                installsCount = 5000000000,
                currentVersion = "2.22.10.73",
                requiresAndroid = 4.1,
            ),
            App(
                name = "App 18",
                company = "Game Insight",
                category = "Action",
                updatedAt = "May 12 2022".convertStringToDateObject(),
                size = "1.1G".convertSizeToUniqueUnit(),
                installsCount = 50000000,
                currentVersion = "30.0.271",
                requiresAndroid = 5.0,
            )
        )
        assertEquals(topThreeApps, result)
    }
    @Test
    fun should22_ReturnTopAppInstall_When_ItHasLessDataThanRequired() {
        //given valid list of data consisting of three objects
        val apps = listOf(
                App(
                    name = "App 7",
                    company = "WhatsApp LLC",
                    category = "Communication",
                    updatedAt = "May 9 2022".convertStringToDateObject(),
                    size = "800M".convertSizeToUniqueUnit(),
                    installsCount = 5000000000,
                    currentVersion = "2.22.10.73",
                    requiresAndroid = 4.1,
                ),
                App(
                    name = "App 17",
                    company = "WhatsApp LLC",
                    category = "Communication",
                    updatedAt = "May 9 2022".convertStringToDateObject(),
                    size = "800M".convertSizeToUniqueUnit(),
                    installsCount = 5000000000,
                    currentVersion = "2.22.10.73",
                    requiresAndroid = 4.1,
                ),
                App(
                    name = "App 18",
                    company = "Game Insight",
                    category = "Action",
                    updatedAt = "May 12 2022".convertStringToDateObject(),
                    size = "1.1G".convertSizeToUniqueUnit(),
                    installsCount = 50000000,
                    currentVersion = "30.0.271",
                    requiresAndroid = 5.0,
                )
        )
        //when fined top 10 app install
        val result = analyzer.getTopInstalledApps(apps = apps, top = 10)
        //then should return this list apps data
        val topThreeApps = listOf(
            App(
                name = "App 7",
                company = "WhatsApp LLC",
                category = "Communication",
                updatedAt = "May 9 2022".convertStringToDateObject(),
                size = "800M".convertSizeToUniqueUnit(),
                installsCount = 5000000000,
                currentVersion = "2.22.10.73",
                requiresAndroid = 4.1,
            ),
            App(
                name = "App 17",
                company = "WhatsApp LLC",
                category = "Communication",
                updatedAt = "May 9 2022".convertStringToDateObject(),
                size = "800M".convertSizeToUniqueUnit(),
                installsCount = 5000000000,
                currentVersion = "2.22.10.73",
                requiresAndroid = 4.1,
            ),
            App(
                name = "App 18",
                company = "Game Insight",
                category = "Action",
                updatedAt = "May 12 2022".convertStringToDateObject(),
                size = "1.1G".convertSizeToUniqueUnit(),
                installsCount = 50000000,
                currentVersion = "30.0.271",
                requiresAndroid = 5.0,
            )
        )
        assertEquals(topThreeApps, result)
    }

    @Test
    fun should_ReturnEmptyList_When_TheListIsEmpty() {
        //liven empty list
        fakeApps = listOf()
        //when search for find top ten app Install
        val result = analyzer.getTopInstalledApps(apps = fakeApps , top = 10)
        //then should return empty list
        assertEquals(listOf(), result)
    }
    @Test
    fun should_ReturnEmptyList_When_TheEnterNumberOfAppsIsZero() {
        //given fake data from our class FakeData as list call fakeApps
        val appList =  fakeApps
        //when search for top 3 app install
        val result = analyzer.getTopInstalledApps(apps = appList, top =  0)
        //then should return empty list
        assertEquals(listOf(), result)
    }
    @Test
    fun should_ReturnEmptyList_When_AppsNumberIsNegative() {
        //given fake data from our class FakeData as list call fakeApps
        val appList =  fakeApps
        //when search for top 3 app install
        val result = analyzer.getTopInstalledApps(apps = appList, top =  -1)
        //then should return empty list
        assertEquals(listOf(), result)
    }

    /**
     * test function largestAppDevelopedSpecificCompany()
     */
    //test fun_5
    @Test
    fun should_ReturnNull_when_Company_not_include_in_list_app(){
        //when get largest App Developed Specific Company
        val result = analyzer.getLargestAppByCompany(fakeApps," SpaceX ")
        //then find the result
        assertNull(result)
    }

    @Test
    fun should_ReturnNull_when_Company_correct(){
        //when get largest App Developed Specific Company
        val result = analyzer.getLargestAppByCompany(fakeApps, "Google LLC")
        //then find the result
        var exception: App = App(
            name = "App 8",
            company = "Google LLC",
            category = "Tools",
            updatedAt = "May 12 2022".convertStringToDateObject(),
            size = "28M".convertSizeToUniqueUnit(),
            installsCount = 100000,
            currentVersion = "Varies with device",
            requiresAndroid = 9.1
        )
        assertEquals(exception,result)
    }
    @Test
    fun should_ReturnNull_when_Company_Not_contains_list(){
        //give
        var faker: List<App> = listOf()
        //when get largest App Developed Specific Company
        val result = analyzer.getLargestAppByCompany(faker,"App")
        //then find the result
        assertNull(result)
    }

}
