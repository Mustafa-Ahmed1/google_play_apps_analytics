package utility.extension

fun String.toRequiredAndroidVersion(): Double? = split(" ").first().toDoubleOrNull()