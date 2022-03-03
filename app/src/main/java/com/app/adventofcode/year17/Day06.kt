package com.app.adventofcode.year17

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day06(context: Context) : Day(context, 6, 2017) {

private val TAG="Day06"

    val resultList by lazy {  block(data = listItem1[0].split(" ").map { it.toInt() }.toMutableList(), currentItem = listItem1[0]) }
    var currentItemRes=""
    override fun partOne(): Any {
        return resultList.size
    }

    private tailrec fun block(list: ArrayList<String> = ArrayList(), data: MutableList<Int>, currentItem: String,type : Int=0): ArrayList<String> =
        if (list.contains(currentItem)) {
            currentItemRes=currentItem
            list
        }
        else {
            list.add(currentItem)
            val (maxIndex,maxValue)=data.withIndex().maxByOrNull { it.value }!!
            data[maxIndex]=0
            repeat(maxValue){
                val index=(maxIndex+it+1) % data.size
                data[index]+=1
            }
            block(list,data,data.joinToString(" "),type)
        }


    override fun partTwo(): Any {
        return resultList.size-resultList.indexOf(currentItemRes)
    }
}