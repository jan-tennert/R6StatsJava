package de.jan.r6statsjava


class R6GameTime(val seconds: Long) {

    fun toMilliseconds() : Long {
        return seconds * 1000.toLong()
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

    fun toMinutesPart() : Long {
        return (seconds % 3600) / 60
    }

    fun toSecondsPart() : Long {
        return seconds % 60
    }

    fun toDuration() : String {
        return String.format("%d:%02d:%02d", toHours().toInt(), toMinutesPart(), toSecondsPart())
    }

    override fun toString(): String {
        return toDuration()
    }

}