package com.app.adventofcode.year17

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Day02(context: Context) : Day(context, 2, 2017) {
    private val TAG="Day02"
    override fun partOne(): Any {
        var sum = 0L
        listItemTab.forEach {
            var minValue = Long.MAX_VALUE
            var maxValue = Long.MIN_VALUE
            it.forEach { value ->
                val current = value.toLong()
                maxValue = max(current, maxValue)
                minValue = min(current, minValue)
            }
            sum += abs(minValue - maxValue)
        }
        return sum
    }

    override fun partTwo(): Any {
        var sum = 0L
        listItemTab.forEach {
            var flag=false
            for(x in 0 until it.size){
                for ( y in x until it.size){
                    val dataX=it[x].toLong()
                    val dataY=it[y].toLong()
                    if(dataX!=0L && dataY!=0L && x!=y){

                        if(dataX%dataY==0L){
                            sum+=(dataX/dataY)
                            flag=true
                            break
                        }else if(dataY%dataX==0L){
                            sum+=(dataY/dataX)
                            flag=true
                            break
                        }
                    }
                }
                if(flag)
                    break
            }

        }
        return sum
    }
}