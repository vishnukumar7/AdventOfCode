package com.app.adventofcode.year22

import android.content.Context
import com.app.adventofcode.Day

class Day04(context: Context) : Day(context,4,2022) {
    override fun partOne(): Any {
        var count=0
        listItem1.forEach {
            val pairs=it.split(",")
            val firstRange=pairs[0].split("-")
            val secondRange=pairs[1].split("-")
            if((firstRange[0].toInt()>=secondRange[0].toInt() && firstRange[1].toInt()<=secondRange[1].toInt())
                || (firstRange[0].toInt()<=secondRange[0].toInt() && firstRange[1].toInt()>=secondRange[1].toInt()))
                count++
        }
        return count
    }

    override fun partTwo(): Any {
        var count=0
        listItem1.forEach {
            val pairs=it.split(",")
            val firstRange=pairs[0].split("-").map { it.toInt() }
            val secondRange=pairs[1].split("-").map { it.toInt() }
            loop@ for (range in firstRange[0]..firstRange[1]){
                if(range in secondRange[0]..secondRange[1]){
                    count++
                    break@loop
                }
            }
        }
        return count
    }

}
