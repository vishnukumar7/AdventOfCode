package com.app.adventofcode.year17

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day11(context: Context): Day(context,11,2017) {

    private val TAG="Day11"

    override fun partOne(): Any {
        listItem.forEach {
            
            val list=it.split(",")
            val mapList=HashMap<String,Int>()
            list.forEach {
                val value=(mapList[it] ?: 0)
                when (it) {
                    "ne" -> {
                        val opp=(mapList["sw"] ?: 0)
                        if(opp==0)
                            mapList[it]=value+1
                        else
                            mapList["sw"]=opp-1
                    }

                    "sw" -> {
                        val opp=(mapList["ne"] ?: 0)
                        if(opp==0)
                            mapList[it]=value+1
                        else
                            mapList["ne"]=opp-1
                    }

                    "nw" -> {
                        val opp=(mapList["se"] ?: 0)
                        if(opp==0)
                            mapList[it]=value+1
                        else
                            mapList["se"]=opp-1
                    }

                    "se" -> {
                        val opp=(mapList["nw"] ?: 0)
                        if(opp==0)
                            mapList[it]=value+1
                        else
                            mapList["nw"]=opp-1
                    }

                    "n" -> {
                        val opp=(mapList["s"] ?: 0)
                        if(opp==0)
                            mapList[it]=value+1
                        else
                            mapList["s"]=opp-1
                    }

                    "s" -> {
                        val opp=(mapList["n"] ?: 0)
                        if(opp==0)
                            mapList[it]=value+1
                        else
                            mapList["n"]=opp-1
                    }
                }
            }

            Log.d(TAG, "partOne: $mapList")

        }
        return 0
    }

    override fun partTwo(): Any {
        return 0
    }
}