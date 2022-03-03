package com.app.adventofcode.yearTwenty

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day03(context: Context): Day(context,3,2020){
    private val TAG="TobogganTrajectory"
    private var currentListItem=ArrayList<String>()

    fun init(){
        for(item in listItem){
            var list=""
            for (data in 0..120)
                list+=item
            currentListItem.add(item)
        }
    }

    override fun partOne(): Long {
        init()
        var count=0
        var totalRow=currentListItem.size
        var startRow=1
        var column=1
        while (startRow<totalRow){
            column+=3
            startRow+=1
            val res= currentListItem[startRow-1].toCharArray()[column-1].toString()
            if(res=="#")
                count++
        }
        Log.d(TAG, "getTrees: $count")
        return count.toLong()
    }

    override fun partTwo(): Long {
        return getTreesR11()* getTreesR12()*getTreesR31()*getTreesR51()*getTreesR71()
    }

    fun getTreesR11(): Long {
        var count=0
        var totalRow=currentListItem.size
        var startRow=1
        var column=1
        while (startRow<totalRow){
            column+=1
            startRow+=1
            val res= currentListItem[startRow-1].toCharArray()[column-1].toString()
            if(res=="#")
                count++
        }
        Log.d(TAG, "getTrees: $count")
        return count.toLong()
    }


    fun getTreesR31(): Long {
        var count=0
        var totalRow=currentListItem.size
        var startRow=1
        var column=1
        while (startRow<totalRow){
            column+=3
            startRow+=1
            val res= currentListItem[startRow-1].toCharArray()[column-1].toString()
            if(res=="#")
                count++
        }
        Log.d(TAG, "getTrees: $count")
        return count.toLong()
    }

    fun getTreesR51(): Long {
        var count=0
        var totalRow=currentListItem.size
        var startRow=1
        var column=1
        while (startRow<totalRow){
            column+=5
            startRow+=1
            val res= currentListItem[startRow-1].toCharArray()[column-1].toString()
            if(res=="#")
                count++
        }
        Log.d(TAG, "getTrees: $count")
        return count.toLong()
    }


    fun getTreesR71(): Long {
        var count=0
        var totalRow=currentListItem.size
        var startRow=1
        var column=1
        while (startRow<totalRow){
            column+=7
            startRow+=1
            val res= currentListItem[startRow-1].toCharArray()[column-1].toString()
            if(res=="#")
                count++
        }
        Log.d(TAG, "getTrees: $count")
        return count.toLong()
    }

    fun getTreesR12(): Long {
        var count=0
        var totalRow=currentListItem.size
        var startRow=1
        var column=1
        while (startRow<totalRow){
            column+=1
            startRow+=2
            val res= currentListItem[startRow-1].toCharArray()[column-1].toString()
            if(res=="#")
                count++
        }
        Log.d(TAG, "getTrees: $count")
        return count.toLong()
    }



}