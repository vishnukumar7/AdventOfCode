package com.app.adventofcode.year15

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import kotlin.math.abs

class Day08(context: Context): Day(context,8,2015) {
    private val TAG = "Matchsticks"
    override fun partOne(): Int {
        var sumChar = 0
        var charLength = 0
        for (item in listItem) {
            sumChar += item.length
            val charCode = item.toCharArray().map { it.toInt() }
            charLength += values(charCode)
        }
        return abs(charLength - sumChar)
    }

    override fun partTwo(): Int {
        var sumChar = 0
        var charLength = 0
        for (item in listItem) {
            sumChar += item.length
            val tempCharCode = item.toCharArray().map { it.toInt() }

            val charCode = ArrayList<Int>()
            var prev = -1
            tempCharCode.forEachIndexed { index, code ->
                if (code == 34) {
                    if (prev == -1) {
                        charCode.add(code)
                        charCode.add(92)
                        charCode.add(code)
                    } else {
                        charCode.add(92)
                        charCode.add(code)
                        if(index==tempCharCode.size-1)
                            charCode.add(code)
                    }
                } else if (code == 92) {
                    charCode.add(code)
                    charCode.add(code)
                } else
                    charCode.add(code)
                prev = code

        }
        charLength += charCode.size
    }
    return abs(charLength - sumChar)
}


private fun values(charCode: List<Int>): Int {
    var prev = -1
    var length = 0
    var index = 0
    charCode.forEach { code ->
        if (index == 0) {
            when {
                code == 34 && prev == 92 -> {
                    length++
                    prev = code
                }
                code == 92 && prev == 92 -> {
                    length++
                    prev = -1
                }
                code == 120 && prev == 92 -> {
                    length++
                    index = 2
                    prev = -1
                    prev = code
                }
                code != 34 && code != 92 -> {
                    length++
                    prev = code
                }
                else -> prev = code
            }
        } else {
            index--
        }
    }
    return length
}


}