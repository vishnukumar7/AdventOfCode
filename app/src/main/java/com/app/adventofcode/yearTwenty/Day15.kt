package com.app.adventofcode.yearTwenty

import android.content.Context
import com.app.adventofcode.Day

class Day15(context: Context): Day(context,15,2020) {
    var numberString="0,3,6"

   override fun partOne(){


   }

    override fun partTwo(): Int {
        return -1
    }
    /*private fun memoryGame(): Sequence<Int> = sequence {
      //  var startingNumbers=numberString.mapIndexed { index, c -> c to index }.toMap().toMutableMap()
        yieldAll(numberString)
        val memory = numberString.mapIndexed { index, i -> i to index }.toMap().toMutableMap()
        var turns = numberString.size
        var sayNext = 0
        while(true) {
            yield(sayNext)
            val lastTimeSpoken = memory[sayNext] ?: turns
            memory[sayNext] = turns
            sayNext = turns - lastTimeSpoken
            turns++
        }
    }*/
}