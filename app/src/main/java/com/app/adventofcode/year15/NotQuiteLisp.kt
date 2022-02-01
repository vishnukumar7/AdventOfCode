package com.app.adventofcode.year15

import android.util.Log

class NotQuiteLisp(private var listItem: ArrayList<String>) {

    fun partOne(): Int {
        val floorUp=listItem[0].count { it=='('}
        val floorDown=listItem[0].count { it==')'}
        return floorUp-floorDown
    }

    fun partTwo(): Int {
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