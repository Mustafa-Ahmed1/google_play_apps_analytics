package utility.extension

fun String.convertStringToDouble(): Double? =split(" ").first().toDoubleOrNull()