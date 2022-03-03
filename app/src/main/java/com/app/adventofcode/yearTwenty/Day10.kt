package com.app.adventofcode.yearTwenty

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day10(context: Context): Day(context,10,2020) {
private val TAG="AdapterArray"

    private val listAdapter: ArrayList<Int> = ArrayList()
    init {
        for(item in listItem){
            listAdapter.add(item.toInt())
        }
    }

    override fun partOne(){
        var diff1=1
        var diff3=1
        listAdapter.sort()
        for (item in 1 until listAdapter.size){
            Log.d(TAG, "partOne: "+(listAdapter[item-1]-listAdapter[item]))
            if(listAdapter[item]-listAdapter[item-1]==1)
                diff1++
            if(listAdapter[item]-listAdapter[item-1]==3)
                diff3++
        }
        Log.d(TAG, "partOne: diff : "+(diff1*diff3))

    }


    override fun partTwo(): Long {
        listAdapter.sort()
        val adapterMap: MutableMap<Int,Long> = mutableMapOf(0 to 1L)

        listAdapter.forEach {adapter ->
            adapterMap[adapter] = (1 .. 3).map { jolts -> adapterMap.getOrDefault(adapter-jolts,0) }.sum()
            Log.d(TAG, "partTwo1: $adapter $adapterMap")
        }

        Log.d(TAG, "partTwo: ${adapterMap.getValue(listAdapter.last())}")

        return adapterMap.getValue(listAdapter.last())
    }

}