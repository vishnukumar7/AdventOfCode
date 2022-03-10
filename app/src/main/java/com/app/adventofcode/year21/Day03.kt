package com.app.adventofcode.year21

import android.content.Context
import com.app.adventofcode.Day

class Day03(context: Context) : Day(context, 3, 2021) {
    private val TAG = "Day03"
    override fun partOne(): Any {
        val gamma = listItem.first().indices.map { column ->
            if (listItem.count { it[column] == '1' } > listItem.size / 2) '1' else '0'
        }.joinToString("")

        val epsilon = gamma.map { if(it == '1') '0' else '1' }.joinToString("")

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    override fun partTwo(): Any = listItem.bitwiseFilter(true).toInt(2) * listItem.bitwiseFilter(false).toInt(2)

    private fun List<String>.bitwiseFilter(keepMostCommon: Boolean): String =
        first().indices.fold(this) { inputs, column ->
            if (inputs.size == 1) inputs else {
                val split = inputs.partition { it[column] == '1' }
                if(keepMostCommon) split.longest() else split.shortest()
            }
        }.first()

    private fun <T> Pair<List<T>,List<T>>.longest(): List<T> =
        if(first.size >= second.size) first else second

    private fun <T> Pair<List<T>,List<T>>.shortest(): List<T> =
        if(first.size < second.size) first else second
}