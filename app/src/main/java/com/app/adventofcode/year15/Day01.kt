package com.app.adventofcode.year15

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day01(context: Context) : Day(context,1,2015) {

    override fun partOne(): Int {
        val floorUp=listItem[0].count { it=='('}
        val floorDown=listItem[0].count { it==')'}
        return floorUp-floorDown
    }

    override fun partTwo(): Int {
        var floor=0
        for ((index, c ) in listItem[0].withIndex()){
            if(c=='(')
                floor++
            else
                floor--
            if(floor==-1)
            {
                floor=index+1
                break
            }
        }
       return floor

    }
}