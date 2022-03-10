package com.app.adventofcode.year21

import android.content.Context
import com.app.adventofcode.Day
import com.app.adventofcode.model.Coord
import kotlin.math.abs

class Day13(context: Context) : Day(context,13,2021) {

    private var page =listItemMultiList[0].map {
        val c=it.split(",")
        Coord(x= c[0].toInt(),y= c[1].toInt())
    }

    private val instructions =listItemMultiList[1].map {
        Pair(it[it.indexOf("=") - 1], it.slice(it.indexOf("=") + 1 until it.length).toInt())
    }

    override fun partOne(): Any {
        page= page.foldBy(instructions[0].first,instructions[0].second) as ArrayList<Coord>
        return page.size
    }

    override fun partTwo(): Any {
        instructions.forEach {
            page=page.foldBy(it.first,it.second) as ArrayList<Coord>
        }
        return  page.print()
    }


    private fun List<Coord>.print(): String {
        println()
        val width = maxOf { it.x }
        val height = maxOf { it.y }

        val p = Array(size = height + 1) {
            Array(size = width + 1) { '.' }
        }

        forEach { p[it.y][it.x] = '#' }
var result=""
        p.forEach { x ->
            x.forEach {
                print(it)
                result+="$it"
            }
            result+="\n"
            println()
        }
        println()
        return result
    }
    private fun List<Coord>.foldBy(axis: Char, foldLine: Int): List<Coord> {
        val flippers =
            if (axis == 'x') filter { it.x > foldLine }
            else filter { it.y > foldLine }

        flippers.forEach {
            if (axis == 'x') it.x = abs(it.x - (foldLine * 2))
            else it.y = abs(it.y - (foldLine * 2))
        }

        return this.distinct()
    }
}