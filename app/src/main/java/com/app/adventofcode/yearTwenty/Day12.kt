package com.app.adventofcode.yearTwenty

import android.content.Context
import com.app.adventofcode.Day
import kotlin.math.abs

class Day12(context: Context): Day(context,12,2020) {
    private val TAG = "RainRisk"
    var east = 0
    var north = 0
    var south = 0
    var west = 0
    var startPole = 1
    var startPolePart2 = 1
    var starts = "east"
    var startsFirstPart2="east"
    var startSecondPart2="north"
    var startUnitFirst=10
    var startUnitSecond=1

    override fun partOne(): Int {
        listItem.forEach { item ->
            val number = item.substring(1).toInt()
            when (item.first().toString()) {
                "F" -> {
                    when (starts) {
                        "east" -> {
                            moveEast(number)
                        }

                        "west" -> {
                            moveWest(number)
                        }

                        "north" -> {
                            moveNorth(number)
                        }

                        "south" -> {
                            moveSouth(number)
                        }
                    }
                }

                "N" -> {
                    moveNorth(number)
                }

                "S" -> {
                    moveSouth(number)
                }

                "W" -> {
                    moveWest(number)
                }

                "E" -> {
                    moveEast(number)
                }

                "L" -> {
                    turnAngle(number / 90,false)
                }

                "R" -> {
                    turnAngle(number / 90, true)
                }
            }
        }
        return east + west + north + south
    }

    override fun partTwo(): Int{
        listItem.forEach { item ->
            val firstChar = item.first()
            val number = item.substring(1).toInt()
            when (firstChar.toString()) {
                "F" -> {
                    when (startsFirstPart2) {
                        "north" -> {
                            moveNorth(number*startUnitFirst)
                        }
                        "east" -> {
                            moveEast(number*startUnitFirst)
                        }

                        "south" -> {
                            moveSouth(number*startUnitFirst)
                        }
                        "west" -> {
                            moveWest(number*startUnitFirst)
                        }
                    }
                    when (startSecondPart2) {
                        "north" -> {
                            moveNorth(number*startUnitSecond)
                        }
                        "east" -> {
                            moveEast(number*startUnitSecond)
                        }

                        "south" -> {
                            moveSouth(number*startUnitSecond)
                        }
                        "west" -> {
                            moveWest(number*startUnitSecond)
                        }
                    }
                }

                "N" -> {
                    if (startsFirstPart2=="north"){
                        startUnitFirst+=number
                    }else if(startSecondPart2=="north"){
                        startUnitSecond+=number
                    }else if (startsFirstPart2=="south"){
                        startUnitFirst-=number
                        if(startUnitFirst<0) {
                            startUnitFirst = abs(startUnitFirst)
                            startsFirstPart2 = "north"
                        }
                    }else if(startSecondPart2=="south"){
                        startUnitSecond-=number
                        if(startUnitSecond<0) {
                            startUnitSecond = abs(startUnitSecond)
                            startSecondPart2 = "north"
                        }
                    }
                }

                "S" -> {
                    if (startsFirstPart2=="south"){
                        startUnitFirst+=number
                    }else if(startSecondPart2=="south"){
                        startUnitSecond+=number
                    }else if (startsFirstPart2=="north"){
                        startUnitFirst-=number
                        if(startUnitFirst<0) {
                            startUnitFirst = abs(startUnitFirst)
                            startsFirstPart2 = "south"
                        }
                    }else if(startSecondPart2=="north"){
                        startUnitSecond-=number
                        if(startUnitSecond<0) {
                            startUnitSecond = abs(startUnitSecond)
                            startSecondPart2 = "south"
                        }
                    }
                }

                "W" -> {
                    if (startsFirstPart2=="west"){
                        startUnitFirst+=number
                    }else if(startSecondPart2=="west"){
                        startUnitSecond+=number
                    }else if (startsFirstPart2=="east"){
                        startUnitFirst-=number
                        if(startUnitFirst<0) {
                            startUnitFirst = abs(startUnitFirst)
                            startsFirstPart2 = "west"
                        }
                    }else if(startSecondPart2=="east"){
                        startUnitSecond-=number
                        if(startUnitSecond<0) {
                            startUnitSecond = abs(startUnitSecond)
                            startSecondPart2 = "west"
                        }
                    }
                }

                "E" -> {
                    if (startsFirstPart2=="east"){
                        startUnitFirst+=number
                    }else if(startSecondPart2=="east"){
                        startUnitSecond+=number
                    }else if (startsFirstPart2=="west"){
                        startUnitFirst-=number
                        if(startUnitFirst<0) {
                            startUnitFirst = abs(startUnitFirst)
                            startsFirstPart2 = "east"
                        }
                    }else if(startSecondPart2=="west"){
                        startUnitSecond-=number
                        if(startUnitSecond<0) {
                            startUnitSecond = abs(startUnitSecond)
                            startSecondPart2 = "east"
                        }
                    }
                }

                "L" -> {
                    turnAnglePart2(number / 90,false)
                }

                "R" -> {
                    turnAnglePart2(number / 90,true)
                }
            }
        }
        return east + west + north + south
    }

    private fun moveNorth(number: Int) {
        if (south != 0) {
            if (south > number) {
                south -= number
            } else {
                val temp = number - south
                south = 0
                north += temp
            }
        } else {
            north += number
        }
    }

    private fun moveEast(number: Int) {
        if (west != 0) {
            if (west > number) {
                west -= number
            } else {
                val temp = number - west
                west = 0
                east += temp
            }
        } else {
            east += number
        }
    }

    private fun moveSouth(number: Int) {
        if (north != 0) {
            if (north > number) {
                north -= number
            } else {
                val temp = number - north
                north = 0
                south += temp
            }
        } else {
            south += number
        }
    }

    private fun moveWest(number: Int) {
        if (east != 0) {
            if (east > number) {
                east -= number
            } else {
                val temp = number - east
                east = 0
                west += temp
            }
        } else {
            west += number
        }
    }


    private fun turnAngle(values: Int,right: Boolean) {
        if(right){
            startPole += values
            startPole = (startPole % 4)
        }
        else {
            for (index in values downTo 1) {
                if (startPole == 0)
                    startPole = 4
                startPole--
            }
        }
        when (startPole) {
            0 -> {
                starts = "north"
            }

            1 -> {
                starts = "east"
            }

            2 -> {
                starts = "south"
            }

            3 -> {
                starts = "west"
            }
        }
    }

    private fun turnAnglePart2(values: Int,right: Boolean) {
        if(right){
            for (index in values downTo 1) {
                startSecondPart2=getAngleClockwise(startSecondPart2)
                startsFirstPart2=getAngleClockwise(startsFirstPart2)
            }

        }else {
            for (index in values downTo 1) {
                startSecondPart2=getAngleAntiClockwise(startSecondPart2)
                startsFirstPart2=getAngleAntiClockwise(startsFirstPart2)
            }
        }
    }

    private fun getAngleClockwise(values: String): String{
        return when(values){
            "north" -> {
                "east"
            }

            "east" -> {
                "south"
            }

            "south" -> {
                "west"
            }

            "west" -> {
                "north"
            }
            else -> {
                ""
            }
        }

    }

    private fun getAngleAntiClockwise(values: String): String{
        return when(values){
            "north" -> {
                "west"
            }

            "east" -> {
                "north"
            }

            "south" -> {
                "east"
            }

            "west" -> {
                "south"
            }
            else -> {
                ""
            }
        }

    }

}