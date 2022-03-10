package com.app.adventofcode.year17

import android.content.Context
import com.app.adventofcode.Day

class Day09(context: Context): Day(context,9,2017) {

    private val cancel = "!.".toRegex()
    private val garbage = "<.*?>".toRegex()
    private val nonGroup = "[^{}]".toRegex()


    private val cleanInput = listItem[0].replace(cancel, "")
    override fun partOne(): Any = scoreGroups(cleanInput.replace(garbage, "").replace(nonGroup, "").toList())

    private tailrec fun scoreGroups(stream: List<Char>, score: Int = 0, depth: Int = 1): Int =
        when {
            stream.isEmpty() -> score
            stream.first() == '}' -> scoreGroups(stream.drop(1), score, depth - 1)
            else -> scoreGroups(stream.drop(1), score + depth, depth + 1)
        }


    override fun partTwo(): Any = garbage.findAll(cleanInput).sumBy { it.value.length - 2 }
}