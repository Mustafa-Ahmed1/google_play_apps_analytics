package utility.extension

import java.text.SimpleDateFormat
import java.util.*

fun String.toDateObject(): Date {
    return SimpleDateFormat("MMMM d yyyy").parse(this)
}