package com.app.adventofcode.year21

import android.content.Context
import com.app.adventofcode.Day

class Day02(context: Context) : Day(context, 2, 2021) {

    override fun partOne(): Any? {
        var f = 0L
        var d = 0L
        listItem.map {
            val item = it.split(" ")
            when (item[0]) {
                "forward" -> f += item[1].toLong()
                "down" -> d += item[1].toLong()
                "up" -> d -= item[1].toLong()
            }
        }
        return f * d
    }

    override fun partTwo(): Any? {
        var forward = 0L
        var aim = 0L
        var depth = 0L
        listItem.map {
            val item = it.split(" ")
            when (item[0]) {
                "forward" -> {
                    forward+=item[1].toLong()
                    depth+=item[1].toLong()*aim
                }
                "down" -> {
                    aim+=item[1].toLong()
                }
                "up" -> {
                    aim-=item[1].toLong()
                }
            }
        }

        return forward*depth
    }
}