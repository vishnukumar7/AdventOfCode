package com.app.adventofcode.year15

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day10(context: Context) : Day(context ,15,2015) {
private val TAG="LookSay"
    override fun partOne(): Int {
        var item = listItem[0]
        repeat(40) {
            var temp = item.toCharArray()
            var prev = '-'
            var count = 0
            var res = ""
            for (index in temp.indices) {
                if (index == 0) {
                    count++
                } else {
                    if (prev == temp[index]) {
                        count++
                    } else {
                        res += "" + count + "" + prev
                        count = 1
                    }
                }
                prev = temp[index]
            }
            res += "" + count + "" + prev
            Log.d(TAG, "partOne: $res")
            item=res
        }
        return item.length
    }

    override fun partTwo(): Int {
        return -1
    }

    /*private fun lookAndSay(times: Int): Int {
        var (s, repetitions) = listItem[0]
        (0 until times).forEach { _ ->
            s = repetitions.findAll(s).fold(StringBuilder()) { acc, c ->
                acc.append("${c.value.length}${c.value[0]}")}.toString()
        }
        return s.length
    }*/
}