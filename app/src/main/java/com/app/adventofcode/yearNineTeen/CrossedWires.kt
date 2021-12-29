package com.app.adventofcode.yearNineTeen

import android.util.Log
import kotlin.math.abs

class CrossedWires(private var listItem: ArrayList<String>) {
private val TAG="CrossedWires"
    var x=0
    var y=0


    fun partOne(): Long {
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