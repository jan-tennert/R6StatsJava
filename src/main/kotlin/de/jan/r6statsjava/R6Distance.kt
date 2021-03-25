package de.jan.r6statsjava

class R6Distance(val meters: Long) {

    fun toKilometers() : Double {
        return meters / 1000.toDouble()
    }

    fun toMiles() : Double {
        return meters / 1609.toDouble()
    }

    fun toFeet() : Double {
        return meters * 3.281
    }

    fun toYard() : Double {
        return meters * 1.094
    }

}