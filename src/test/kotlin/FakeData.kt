import models.App
import java.time.LocalDate
import java.time.Month

class FakeData {
    val fakeApps= listOf(
        App(
            name = "App 1",
            company = "Google",
            category = "Libraries & Demo",
            updatedAt = LocalDate.of(2010,Month.SEPTEMBER,4),
            size = "5.0M",
            installsCount = 5,
            currentVersion = "1",
            requiresAndroid = "4.4 and up",
        ),
        App(
            name = "App 2",
            company = "Google LLC",
            category = "Medical",
            updatedAt = LocalDate.of(2001,Month.SEPTEMBER,26),
            size = "22M",
            installsCount = 100000,
            currentVersion = "1.4.4-0e73d19a",
            requiresAndroid = "7.0 and up",
        ),
        App(
            name = "App 3",
            company = "Clipto Team",
            category = "Productivity",
            updatedAt = LocalDate.of(2021,Month.DECEMBER,24),
            size = "28M",
            installsCount = 100000,
            currentVersion = "6.0.16-release",
            requiresAndroid = "5.0 and up",
        ),
        App(
            name = "App 4",
            company = "Pazu Games",
            category =  "Medical",
            updatedAt = LocalDate.of(2021,Month.DECEMBER,24),
            size = "42M",
            installsCount = 100000,
            currentVersion = "1.4.4-0e73d19a",
            requiresAndroid = "7.0 and up",
        ),
        App(
            name = "App 5",
            company = "Weedmaps",
            category = "Medical",
            updatedAt =LocalDate.of(2020,Month.MARCH,4),
            size = "1.1G",
            installsCount = 1800000,
            currentVersion = "7.0.2",
            requiresAndroid = "5.0 and up",
        ),
        App(
            name = "App 6",
            company = "Craigpark Limited",
            category = "Productivity",
            updatedAt = LocalDate.of(2011,Month.APRIL,6),
            size = "63M",
            installsCount = 5000000,
            currentVersion = "14.18.0.36314",
            requiresAndroid = "5.0 and up",
        ),
        App(
            name = "App 7",
            company = "WhatsApp LLC",
            category = "Communication",
            updatedAt = LocalDate.of(2022,Month.MAY,9),
            size = "800M",
            installsCount = 5000000000,
            currentVersion = "2.22.10.73",
            requiresAndroid = "4.1 and up",

        ),
        App(
            name = "App 8",
            company = "Google LLC",
            category = "Tools",
            updatedAt = LocalDate.of(2022,Month.MAY,12),
            size = "28M",
            installsCount = 100000,
            currentVersion = "Varies with device",
            requiresAndroid = "Varies with device",
        ),
        App(
            name = "App 9",
            company = "WhatsApp LLC",
            category = "Communication",
            updatedAt = LocalDate.of(2012,Month.NOVEMBER,9),
            size = "42M",
            installsCount = 5000000,
            currentVersion = "Varies with device",
            requiresAndroid = "7.0 and up",
        ),
        App(
            name = "App 10",
            company = "Area 120 by Google",
            category = "Casual",
            updatedAt = LocalDate.of(2020,Month.DECEMBER,9),
            size = "117M",
            installsCount = 1800000,
            currentVersion = "8.5.0g",
            requiresAndroid = "5.0 and up",
        ),
        App(
            name = "App 11",
            company = "Azur Interactive Games Limited",
            category = "Action",
            updatedAt = LocalDate.of(2022,Month.JANUARY,25),
            size = "87M",
            installsCount = 10000000,
            currentVersion = "0.17.1",
            requiresAndroid = " 9 and up",
        ),
        App(
            name = "App 12",
            company = "Vidma Video Studio",
            category = "Video Players & Editors",
            updatedAt = LocalDate.of(2022,Month.MAY,19),
            size = "64M",
            installsCount = 1000000,
            currentVersion = "1.16.2",
            requiresAndroid = "9 and up",
        ),
        App(
            name = "App 13",
            company = "AIBY Inc.",
            category = "Education",
            updatedAt = LocalDate.of(2022,Month.MAY,13),
            size = "37M",
            installsCount = 1000000,
            currentVersion = "2.25.4",
            requiresAndroid = "9 and up",
        ),
        App(
            name = "App 14",
            company = "Pazu Games",
            category = "Medical",
            updatedAt = LocalDate.of(2022,Month.DECEMBER,15),
            size = "42M",
            installsCount = 100000,
            currentVersion = "1.4.4-0e73d19a",
            requiresAndroid = "7.0 and up",
        ),
        App(
            name = "App 15",
            company = "Weedmaps",
            category = "Medical",
            updatedAt = LocalDate.of(2022,Month.MARCH,4),
            size = "9.6M",
            installsCount = 1000000,
            currentVersion = "7.0.2",
            requiresAndroid = "5.0 and up",
        ),
        App(
            name = "App 16",
            company = "Craigpark Limited",
            category = "Productivity",
            updatedAt = LocalDate.of(2022,Month.APRIL,7),
            size = "Varies with device",
            installsCount = 1000000,
            currentVersion = "5.3.5",
            requiresAndroid = "5.0 and up",
        ),
        App(
            name = "App 17",
            company = "WhatsApp LLC",
            category = "Communication",
            updatedAt = LocalDate.of(2022,Month.MAY,9),
            size = "800M",
            installsCount = 5000000000,
            currentVersion = "2.22.10.73",
            requiresAndroid = "4.1 and up",
        ),
        App(
            name = "App 18",
            company = "Game Insight",
            category = "Action",
            updatedAt = LocalDate.of(2022,Month.MAY,12),
            size = "1.1G",
            installsCount = 50000000,
            currentVersion = "30.0.271",
            requiresAndroid = "5.0 and up",
        ),
        App(
            name = "App 19",
            company = "TIMEFLIK (ex MR TIME)",
            category = "Personalization",
            updatedAt = LocalDate.of(2021,Month.DECEMBER,15),
            size = "4.7M",
            installsCount = 5000000,
            currentVersion = "10, 1.0.0",
            requiresAndroid = "9 and up",
        ),
        App(
            name = "App 20",
            company = "Area 120 by Google",
            category = "Personalization",
            updatedAt = LocalDate.of(2020,Month.AUGUST,9),
            size = "117M",
            installsCount = 10,
            currentVersion = "8.5.0g",
            requiresAndroid = "5.0 and up",
        ),
    )
}