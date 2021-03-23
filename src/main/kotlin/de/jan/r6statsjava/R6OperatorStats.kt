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


}