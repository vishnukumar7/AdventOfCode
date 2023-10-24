package com.app.adventofcode.year22

import android.content.Context
import com.app.adventofcode.Day

class Day01(context: Context) : Day(context,1,2022) {
    override fun partOne(): Any = listItemSentence.maxOf { it.trim().split(" ").sumOf { it.toInt() }.toLong() }

    override fun partTwo(): Any {
        val ans= listItemSentence.map { it.trim().split(" ").sumOf { it.toLong() } }.sorted()
        val lastIndex=ans.lastIndex
        return ans[lastIndex]+ans[lastIndex-1]+ans[lastIndex-2]
    }
}
