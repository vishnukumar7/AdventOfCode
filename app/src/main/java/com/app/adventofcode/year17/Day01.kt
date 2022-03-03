package com.app.adventofcode.year17

import android.content.Context
import com.app.adventofcode.Day

class Day01(context: Context) : Day(context, 1, 2017) {

    override fun partOne(): Any {
        var sum = 0L
        val data = listItem[0].toList()
        val next = data.size
        for ((index, element) in data.withIndex()) {
            val x = element.digitToInt()
            if (next == index + 1) {
                val y = data[0].digitToInt()
                if(x==y){
                    sum+=x
                }
            } else {
                val y = data[index + 1].digitToInt()
                if(x==y){
                    sum+=x
                }
            }
        }
        return sum
    }


    override fun partTwo(): Any {
        var sum = 0L
        val data = listItem[0].toList()
        var next=data.size/2
        var index=0
        while (next!=data.size){
            if(data[index]==data[next]){
                sum+=(2*data[index].digitToInt())
            }
            next++
            index++
        }
        return sum
    }

}