package com.app.adventofcode.yearTwenty

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class BinaryBoardingDayFive(private var listItem: ArrayList<String>) {

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

    fun partOne(): Int {
        val resultList=getBoardingPass()
        return resultList[resultList.size-1]
    }

    fun partTwo(): Int {
        val resultList=getBoardingPass()
        for (pass in 84..866){
            if(!resultList.contains(pass))
                return pass
        }
      return 0
    }
}