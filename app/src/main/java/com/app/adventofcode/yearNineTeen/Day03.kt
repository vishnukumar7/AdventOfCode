package com.app.adventofcode.yearNineTeen

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import kotlin.math.abs

class Day03(context: Context): Day(context,3,2019) {
private val TAG="CrossedWires"
    var array=Array(1){CharArray(1)}
    var x=0
    var y=0
    var increase=0
    var sum=0
    init {
        array[0][0]='0'
    }

    override fun partOne(): Long {
        var smaller=Long.MAX_VALUE
        val arrayWireOne=wirePos(listItem[0].split(",").toMutableList())
        val arrayWireTwo=wirePos(listItem[1].split(",").toMutableList())
        for((pos, wire1) in arrayWireOne.withIndex()){
            if(arrayWireTwo.contains(wire1)) {
                var split=wire1.split(",")
                val result= abs(split[0].toInt())+ abs(split[1].toInt())
                Log.d(TAG, "partOne: wire1 $wire1")
                Log.d(TAG, "partOne: result $result")
                if(result<smaller)
                    smaller= result.toLong()
            }
        }
        return smaller

    }

    override fun partTwo(): Long {
        var smaller=Long.MAX_VALUE
        val arrayWireOne=wirePos(listItem[0].split(",").toMutableList())
        val arrayWireTwo=wirePos(listItem[1].split(",").toMutableList())
        for((pos, wire1) in arrayWireOne.withIndex()){
            if(arrayWireTwo.contains(wire1)) {
                Log.d(TAG, "partTwo: ${pos+1} ${arrayWireTwo.indexOf(wire1)+1}")
                Log.d(TAG, "partTwo: total ${pos+arrayWireTwo.indexOf(wire1)+2}")
                val result=pos+arrayWireTwo.indexOf(wire1)+2
                if(result<smaller) {
                    smaller = result.toLong()
                    Log.d(TAG, "partTwo: smaller $smaller")
                }
            }
        }
        return smaller

    }

    private fun wirePos(mutableList: MutableList<String>): ArrayList<String> {
        val arrayWireList= ArrayList<String>()
        x=0
        y=0
        for(item in mutableList){
            val data=item[0].toString()

            var values=item.substring(1).toInt()
            when(data){
                "R" -> {
                    while(values--!=0){
                        y++
                        arrayWireList.add("$x,$y")
                    }
                }
                "L" -> {
                    while (values--!=0){
                        y--
                        arrayWireList.add("$x,$y")
                    }
                }

                "U" -> {
                    while (values--!=0){
                        x--
                        arrayWireList.add("$x,$y")
                    }
                }

                "D" -> {
                    while (values--!=0){
                        x++
                        arrayWireList.add("$x,$y")
                    }
                }
            }
        }
        return arrayWireList
    }


}