package com.app.adventofcode.year15

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day03(context: Context) : Day(context,3,2015) {
    private val TAG = "PerfectlySpherical"
    private var sumList = ArrayList<String>()
    private var santa = ArrayList<String>()
    private var robo = ArrayList<String>()
    override fun partOne(): Int {
        sumList.add("0,0")
        var x = 0
        var y = 0
        val charArray = listItem[0].toCharArray().toList()
        for (item in charArray) {
            when (item) {
                '^' -> {
                    x++
                }

                '>' -> {
                    y++
                }

                '<' -> {
                    y--
                }

                'v' -> {
                    x--
                }
            }
            if (!sumList.contains("$x,$y"))
                sumList.add("$x,$y")
        }
        return sumList.size
    }

    override fun partTwo(): Int {
        var sx = 0
        var sy = 0
        var rx = 0
        var ry = 0
        val charArray = listItem[0].toCharArray().toList()
        for ((index, item) in charArray.withIndex()) {
            when (item) {
                '^' -> {
                    if (index % 2 == 0)
                        sx++
                    else
                        rx++
                }

                '>' -> {
                    if (index % 2 == 0)
                        sy++
                    else
                        ry++
                }

                '<' -> {
                    if (index % 2 == 0)
                        sy--
                    else
                        ry--
                }

                'v' -> {
                    if (index % 2 == 0)
                        sx--
                    else
                        rx--
                }
            }

            if (index % 2 == 0 && (sx != 0 || sy != 0)) {
                if (!santa.contains("$sx,$sy") && !robo.contains("$sx,$sy"))
                    santa.add("$sx,$sy")
            } else if (rx != 0 || ry != 0) {
                if (!robo.contains("$rx,$ry") && !santa.contains("$rx,$ry"))
                    robo.add("$rx,$ry")
            }
        }
        

        Log.d(TAG, "partTwo: ${santa.size} ${robo.size}")

        return santa.size+robo.size+1
    }
}