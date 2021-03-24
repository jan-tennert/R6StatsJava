package de.jan.r6statsjava

import org.json.JSONObject

class R6OperatorStats(data: JSONObject) {

    val operators: Array<R6Operator>

    init {
        val ops = arrayListOf<R6Operator>()
        for (any in data.getJSONArray("operators")) {
            val o = any as JSONObject
            ops.add(R6Operator(o))
        }
        operators = ops.toTypedArray()
    }

    fun getOperator(name: String, ignoreCase: Boolean = true) : R6Operator? {
        var operator: R6Operator? = null
        for (op in operators) {
            if(ignoreCase && op.name.equals(name, ignoreCase = true)) {
                operator = op
            } else if(!ignoreCase && op.name == name) {
                operator = op
            }
        }
        return operator
    }

    fun sortOperatorsBy(value: R6Operator.SortValue) : Array<R6Operator> {
        val ops = operators
        ops.sortWith { o1, o2 ->
            when(value) {
                R6Operator.SortValue.DEATHS -> o1.deaths.compareTo(o2.deaths)
                R6Operator.SortValue.WINS -> o1.wins.compareTo(o2.wins)
                R6Operator.SortValue.KILLS -> o1.kills.compareTo(o2.kills)
                R6Operator.SortValue.KD -> o1.kd.compareTo(o2.kd)
                R6Operator.SortValue.NAME -> o1.name.compareTo(o2.name)
                R6Operator.SortValue.HEADSHOTS -> o1.headshots.compareTo(o2.headshots)
                R6Operator.SortValue.WL -> o1.wl.compareTo(o2.wl)
                R6Operator.SortValue.LOSSES -> o1.losses.compareTo(o2.losses)
                R6Operator.SortValue.PLAYTIME -> o1.playTime.seconds.compareTo(o2.playTime.seconds)
            }
        }
        ops.reverse()
        return ops
    }

    fun sortDefendersBy(value: R6Operator.SortValue) : Array<R6Operator> {
        val ops = getDefenders()
        ops.sortWith { o1, o2 ->
            when(value) {
                R6Operator.SortValue.DEATHS -> o1.deaths.compareTo(o2.deaths)
                R6Operator.SortValue.WINS -> o1.wins.compareTo(o2.wins)
                R6Operator.SortValue.KILLS -> o1.kills.compareTo(o2.kills)
                R6Operator.SortValue.KD -> o1.kd.compareTo(o2.kd)
                R6Operator.SortValue.NAME -> o1.name.compareTo(o2.name)
                R6Operator.SortValue.HEADSHOTS -> o1.headshots.compareTo(o2.headshots)
                R6Operator.SortValue.WL -> o1.wl.compareTo(o2.wl)
                R6Operator.SortValue.LOSSES -> o1.losses.compareTo(o2.losses)
                R6Operator.SortValue.PLAYTIME -> o1.playTime.seconds.compareTo(o2.playTime.seconds)
            }
        }
        ops.reverse()
        return ops
    }


    fun sortAttackersBy(value: R6Operator.SortValue) : Array<R6Operator> {
        val ops = getAttackers()
        ops.sortWith { o1, o2 ->
            when(value) {
                R6Operator.SortValue.DEATHS -> o1.deaths.compareTo(o2.deaths)
                R6Operator.SortValue.WINS -> o1.wins.compareTo(o2.wins)
                R6Operator.SortValue.KILLS -> o1.kills.compareTo(o2.kills)
                R6Operator.SortValue.KD -> o1.kd.compareTo(o2.kd)
                R6Operator.SortValue.NAME -> o1.name.compareTo(o2.name)
                R6Operator.SortValue.HEADSHOTS -> o1.headshots.compareTo(o2.headshots)
                R6Operator.SortValue.WL -> o1.wl.compareTo(o2.wl)
                R6Operator.SortValue.LOSSES -> o1.losses.compareTo(o2.losses)
                R6Operator.SortValue.PLAYTIME -> o1.playTime.seconds.compareTo(o2.playTime.seconds)
            }
        }
        ops.reverse()
        return ops
    }


    fun getDefenders() : Array<R6Operator> {
        val ops = arrayListOf<R6Operator>()
        for (operator in operators) {
            if(operator.role.toLowerCase() == "defender") {
                ops.add(operator)
            }
        }
        return ops.toTypedArray()
    }

    fun getAttackers() : Array<R6Operator> {
        val ops = arrayListOf<R6Operator>()
        for (operator in operators) {
            if(operator.role.toLowerCase() == "attacker") {
                ops.add(operator)
            }
        }
        return ops.toTypedArray()
    }


}