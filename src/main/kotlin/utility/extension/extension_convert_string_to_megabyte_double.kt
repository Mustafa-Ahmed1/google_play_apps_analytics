package utility.extension

fun String.toMegabyte(): Double {
    return when {
        this.contains("M") -> {
            this.dropLast(1).toDouble()
        }
        this.contains("G") -> {
            this.dropLast(1).toDouble() * 1024
        }
        this.contains("K") -> {
            this.dropLast(1).toDouble() / 1024
        }
        else -> 0.0
    }
}
