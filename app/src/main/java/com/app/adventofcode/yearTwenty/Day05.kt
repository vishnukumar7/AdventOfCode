package com.app.adventofcode.yearTwenty

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import java.util.*
import kotlin.collections.ArrayList

class Day05(context: Context): Day(context,5,2020) {

    private val TAG="BinaryBoarding"

    fun getBoardingPass(): List<Int> {
        var seatId=-1
        val valueSet= TreeSet<Int>()
        for(item in listItem){
            var first=0
            var last=127
            var top=0
            var bottom=7
            for(data in item.indices){
                val temp=(last-first+1)/2
                val tempLR=(bottom-top+1)/2
                if(item[data].toString()=="F"){
                    last -= temp
                }else if(item[data].toString()=="B"){
                    first+=temp
                }else if(item[data].toString()=="L"){
                    bottom-=tempLR
                }else if(item[data].toString()=="R"){
                    top+=tempLR
                }
            }
            val tempSeat=(first*8)+top

            if(seatId<tempSeat)
                seatId=tempSeat
            valueSet.add(tempSeat)

        }
        return valueSet.toList()
    }

    override fun partOne(): Int {
        val resultList=getBoardingPass()
        return resultList[resultList.size-1]
    }

    override fun partTwo(): Int {
        val resultList=getBoardingPass()
        for (pass in 84..866){
            if(!resultList.contains(pass))
                return pass
        }
      return 0
    }
}