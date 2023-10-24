package com.app.adventofcode.year22

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day06(context: Context) : Day(context,6,2022){
    override fun partOne(): Any {
        var count=0
        var value=listItem[0].trim()
       repeat(value.length){
            val firstOfPacket=value.substring(0,4)
            val duplicateRemove=firstOfPacket.toSet()
            if(firstOfPacket.length==duplicateRemove.size){
                count+=firstOfPacket.length
                return count.toString()
            }
           value=value.substring(1)
           count++
        }
        return count.toString()
    }

    override fun partTwo(): Any {
        var count=0
        var value=listItem[0].trim()
        repeat(value.length){
            val firstOfPacket=value.substring(0,14)
            val duplicateRemove=firstOfPacket.toSet()
            if(firstOfPacket.length==duplicateRemove.size){
                count+=firstOfPacket.length
                return count.toString()
            }
            value=value.substring(1)
            count++
        }
        return count.toString()
    }

}