package de.jan.r6statsjava

class R6GameTime(val seconds: Long) {

    fun toMilliseconds() : Long {
        return seconds * 1000
    }

    fun toMinutes() : Double {
        return seconds / 60.toDouble()
    }

    fun toHours() : Double {
        return seconds / 3600.toDouble()
    }

    fun toDays() : Double {
        return seconds / 86400.toDouble()
    }

    fun toWeeks() : Double {
        return seconds / 604800.toDouble()
    }

    fun toDuration() : String {
        return String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
    }

    override fun toString(): String {
        return "${toHours()} hours"
    }

}