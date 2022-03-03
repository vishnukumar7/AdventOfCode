package com.app.adventofcode.year17

import android.content.Context
import com.app.adventofcode.Day

class Day04(context: Context) : Day(context, 4, 2017) {


    override fun partOne(): Any =
        listItem1.map { it.split(" ") }.count { it.size == it.toSet().size }

    override fun partTwo(): Any =
        listItem2.map { it.split(" ").map { it.toCharArray().sortedArray().joinToString("") } }
            .count { it.size == it.toSet().size }
}