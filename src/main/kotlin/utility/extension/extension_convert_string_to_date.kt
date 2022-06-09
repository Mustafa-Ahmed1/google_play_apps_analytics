package utility.extension

import java.text.SimpleDateFormat
import java.util.*

fun String.convertStringToDateObject(): Date {
    return SimpleDateFormat("MMMM d yyyy").parse(this)
}