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


}