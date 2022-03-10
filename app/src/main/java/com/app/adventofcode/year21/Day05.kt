package com.app.adventofcode.year21

import android.content.Context
import com.app.adventofcode.Day
import com.app.adventofcode.model.Point2d

class Day05(context: Context):Day(context,5,2021) {
    private val instructions = listItem.map { parseRow(it) }
    private fun solve(lineFilter: (Pair<Point2d, Point2d>) -> Boolean) =
        instructions
            .filter { lineFilter(it) }
            .flatMap { it.first lineTo it.second }
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }

    private fun parseRow(input: String): Pair<Point2d, Point2d> =
        Pair(
            input.substringBefore(" ").split(",").map { it.toInt() }.let { Point2d(it.first(), it.last()) },
            input.substringAfterLast(" ").split(",").map { it.toInt() }.let { Point2d(it.first(), it.last()) }
        )
    override fun partOne(): Any = solve { it.first sharesAxisWith it.second }

    override fun partTwo(): Any = solve { true }

}

