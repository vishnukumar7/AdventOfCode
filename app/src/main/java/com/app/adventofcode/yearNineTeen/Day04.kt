package com.app.adventofcode.yearNineTeen

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day04(context: Context): Day(context,4,2019) {
private val TAG="SecureContainer"
    var itemText="134564-585159"

    override fun partOne(): Int {
       var result=0
        val splitText=itemText.split("-").toList()
        for(item in splitText){
            if(isValidPassword(item.trim()))
                result++
        }
        return result
    }

    override fun partTwo(): Int {
        return -1
    }

    private fun isValidPassword(data: String): Boolean {
        var doubleDigit=false
        var lastChar='0'
        if(data.length!=6)
            return false
        val charArray=data.toCharArray()
        charArray.sort()
        for (value in charArray){
            if(value==lastChar)
                doubleDigit=true
            else if(value<lastChar)
                return false
            lastChar=value
        }
        return doubleDigit
    }


}