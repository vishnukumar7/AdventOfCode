package com.app.adventofcode.yearTwenty

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import com.app.adventofcode.model.AdventCode

class Day08(context: Context): Day(context,8,2020) {
    private val TAG="HandheldHalting"

    override fun partOne(): Long {
        var start: Long=0
        var i=0
        while (i<listItemAdventCode.size){
            val item=listItemAdventCode[i]
            val dataKeys=item.dataItem.trim().split(" ")[0]
            val dataValues=item.dataItem.trim().split(" ")[1]
            if(!item.firstTime)
                break
            if(dataKeys =="nop"){
                listItemAdventCode[i].firstTime=false
                i++
            } else if(dataKeys =="acc"){
                start+=dataValues.toLong()
                listItemAdventCode[i].firstTime=false
                i++
            }else if(dataKeys =="jmp") {
                listItemAdventCode[i].firstTime=false
                i+=dataValues.toInt()

            }
            // Log.d(TAG, "getAccumalutor: $dataKeys $dataValues $start")
        }
        return start
    }

    override fun partTwo(){

    }

}