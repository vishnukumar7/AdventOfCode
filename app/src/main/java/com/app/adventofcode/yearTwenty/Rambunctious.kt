package com.app.adventofcode.yearTwenty

class Rambunctious {
    var numberString="0,3,6"

   fun partOne(){


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