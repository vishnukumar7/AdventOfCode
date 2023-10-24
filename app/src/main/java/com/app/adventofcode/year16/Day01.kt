package com.app.adventofcode.year16

import android.content.Context
import com.app.adventofcode.Day

const val NORTH_LEFT="WEST"
const val NORTH_RIGHT="EAST"
const val EAST_LEFT="NORTH"
const val EAST_RIGHT="SOUTH"
const val SOUTH_LEFT="EAST"
const val SOUTH_RIGHT="WEST"
const val WEST_LEFT="SOUTH"
const val WEST_RIGHT="NORTH"
class Day01(context: Context) : Day(context,1,2016) {

    var face="NORTH"

    override fun partOne(): Any? {
        val list=listItem[0].split(",").forEach {
            val value=it.trim()
            var direction=value[0]
            var steps=value.drop(0).toLong()
        }
        return null
    }

    override fun partTwo(): Any? {
        return null
    }
}





