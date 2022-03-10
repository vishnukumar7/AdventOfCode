package com.app.adventofcode.year17

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day10(context: Context):Day(context,10,2017){
private val TAG="Day10"
    override fun partOne(): Any {
        val list= ArrayList<Int>()
        list += 0..255
        val elementList= listItem[0].split(",").toMutableList()
        var tempIndex=0
        var skipSize=0
        repeat(elementList.size){
            var startIndex=tempIndex
            var endIndex=startIndex+elementList[it].toInt()-1
            while (startIndex<endIndex){
                val start=startIndex%list.size
                val end=endIndex%list.size
                val temp=list[start]
                list[start]=list[end]
                list[end]=temp
                startIndex++
                endIndex--
            }
            tempIndex+=elementList[it].toInt()+skipSize
            tempIndex%=list.size
            skipSize++
            Log.d(TAG, "partOne: $it")
        }
        return (list[0].toLong()*list[1].toLong())
    }

    override fun partTwo(): Any {
        return 0
    }
}