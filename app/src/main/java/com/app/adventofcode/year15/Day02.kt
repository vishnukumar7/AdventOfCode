package com.app.adventofcode.year15

import android.content.Context
import com.app.adventofcode.Day

class Day02(context: Context) : Day(context,2,2015) {

    override fun partOne(): Int {
        var sum = 0
        for (item in listItem) {
            val dataItem = item.split("x")
            val length = dataItem[0].toInt()
            val width = dataItem[1].toInt()
            val height = dataItem[2].toInt()
            sum += (2 * length * width) + (2 * length * height) + (2 * width * height)
            when {
                length >= width && length >= height -> {
                    sum += (width * height)
                }
                width >= length && width >= height -> {
                    sum += (length * height)
                }
                height >= length && height >= width -> {
                    sum += (length * width)
                }
            }
        }
        return sum
    }

    override fun partTwo(): Int {
        var sum = 0
        for (item in listItem) {
            val dataItem = item.split("x")
            val length = dataItem[0].toInt()
            val width = dataItem[1].toInt()
            val height = dataItem[2].toInt()
            sum += (length*width*height)
            when {
                length >= width && length >= height -> {
                    sum += (2*width + 2*height)
                }
                width >= length && width >= height -> {
                    sum += (2*length + 2*height)
                }
                height >= length && height >= width -> {
                    sum += (2*length + 2*width)
                }
            }
        }
        return sum
    }
}