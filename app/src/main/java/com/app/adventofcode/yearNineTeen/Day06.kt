package com.app.adventofcode.yearNineTeen

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day06(context: Context): Day(context,6,2019) {
private val TAG="UniversalOrbit"

    override fun partTwo(): Int {
        return -1
    }

    fun partOne1(){
        var count=1
        for((index, element) in listItem.withIndex()){
            if(!element.contains("COM")){
                count++
                var dataValues=element.split(")")
              //  Log.d(TAG, "partOne: elements ==> $element")
                for (previous in index-1 downTo 0){
                    val dataValuePre=listItem[previous].split(")")
                    if(dataValues[0]==dataValuePre[1]){
                       // Log.d(TAG, "partOne: index ==> $index datavalue ==> $dataValues datavalue pre ==> ${listItem[previous]}")
                        dataValues=listItem[previous].split(")")
                        count++
                    }
                    /*else if (dataValues[0]==dataValuePre[0])
                         count++*/
                }
            }
            Log.d(TAG, "partOne: count $count")
        }
        Log.d(TAG, "partOne: total count $count")
    }

    override fun partOne(){
        val mapData=HashMap<String,String>()
        for(element in listItem){
            val item=element.split(")")
            mapData[item[1]]=item[0]
        }
        Log.d(TAG, "partOne1: map data ==> $mapData")
       for(data in mapData.entries){
           if(data.value!="com"){

           }

       }

    }
}