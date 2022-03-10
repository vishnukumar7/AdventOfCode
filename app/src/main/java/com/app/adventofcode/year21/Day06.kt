package com.app.adventofcode.year21

import android.content.Context
import com.app.adventofcode.Day

class Day06(context: Context): Day(context,6,2021) {

    private val TAG = "Day06"


    override fun partOne(): Any {
        var baseItem = LongArray(8){0}
        val arrays = listItem[0].split(",")
        repeat(6){
            baseItem[it]=arrays.count { value -> it+1==value.toInt() }.toLong()
        }
        repeat(times = 80){
            baseItem=reduceTo(baseItem)
        }

        return baseItem.sum()
    }

    private fun reduceTo(baseItem: LongArray): LongArray {
      /*  val newBaseItem = LongArray(8){0}
            for (x in baseItem.indices) {
                if (x == 0) {
                    newBaseItem[6] += baseItem[x]
                    newBaseItem[8] += baseItem[x]
                } else {
                    newBaseItem[x - 1] += baseItem[x]
                }
            }
        val temp=baseItem.first()*/
        newBaseItem=baseItem.copyOfRange(1,8)

            return newBaseItem

    }

    override fun partTwo(): Any {
        var baseItem = LongArray(8){0}
        val arrays = listItem[0].split(",")
        repeat(6){
            baseItem[it]=arrays.count { value -> it+1==value.toInt() }.toLong()
        }

        repeat(256) {
            baseItem=reduceTo(baseItem)
        }
        return baseItem.sum()
    }
}