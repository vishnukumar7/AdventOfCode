package com.app.adventofcode.year21

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day01(context: Context) : Day(context,1,2021) {
private val TAG="Day01"
    override fun partOne(): Any = listItem.map { it.toInt() }.zipWithNext().count { it.first <it.second }

    override fun partTwo(): Any= listItem.map { it.toInt() }.windowed(3,1) { it.sum() }.zipWithNext().count {it.first <it.second }

}