package com.app.adventofcode.year17

import android.content.Context
import com.app.adventofcode.Day

class Day03(context: Context): Day(context,0,2017) {
    val dataList=Array(3000){IntArray(3000){-1}}
    val dataList2=Array(3000){LongArray(3000){-1}}
    var direction=-1
    val north=1
    val south=2
    val east=3
    val west=4
    override fun partOne(): Any {
        var cx=dataList.size/2
        var cy=dataList.size/2
        dataList[cx][cy]=0
        cy++
        dataList[cx][cy]=1
        direction=north
        repeat(361525){
            when(direction){
                north -> {
                    cx--
                    dataList[cx][cy]=getValue(cx, cy)+1
                    if(dataList[cx][cy-1]==-1)
                        direction=west
                }
                west ->{
                    cy--
                    dataList[cx][cy]=getValue(cx, cy)+1
                    if(dataList[cx+1][cy]==-1)
                        direction=south
                }
                south -> {
                    cx++
                    dataList[cx][cy]=getValue(cx, cy)+1
                    if(dataList[cx][cy+1]==-1)
                        direction=east
                }
                east -> {
                    cy++
                    dataList[cx][cy]=getValue(cx, cy)+1
                    if(dataList[cx-1][cy]==-1)
                        direction=north
                }
            }
        }
        return dataList[cx][cy]
    }

    private fun getValue(cx: Int,cy: Int): Int {
        var value=ArrayList<Int>()
        if(dataList[cx][cy-1]!=-1)
            value.add(dataList[cx][cy-1])
        if(dataList[cx][cy+1]!=-1)
            value.add(dataList[cx][cy+1])
        if(dataList[cx+1][cy]!=-1)
            value.add(dataList[cx+1][cy])
        if(dataList[cx-1][cy]!=-1)
            value.add(dataList[cx-1][cy])
        return if(value.size>0) value.toSortedSet().first() else 0

    }

    private fun getSum(cx: Int,cy: Int): Long {
        var value=ArrayList<Long>()
        if(dataList2[cx][cy-1]!=-1L)  // left
            value.add(dataList2[cx][cy-1])
        if(dataList2[cx][cy+1]!=-1L) // right
            value.add(dataList2[cx][cy+1])
        if(dataList2[cx+1][cy]!=-1L) // bottom
            value.add(dataList2[cx+1][cy])
        if(dataList2[cx-1][cy]!=-1L) //top
            value.add(dataList2[cx-1][cy])
        if(dataList2[cx-1][cy-1]!=-1L) // topleft
            value.add(dataList2[cx-1][cy-1])
        if(dataList2[cx-1][cy+1]!=-1L) // topright
            value.add(dataList2[cx-1][cy+1])
        if(dataList2[cx+1][cy-1]!=-1L) // bottomleft
            value.add(dataList2[cx+1][cy-1])
        if(dataList2[cx+1][cy+1]!=-1L) // bottomright
            value.add(dataList2[cx+1][cy+1])
        return if(value.size>0) value.sum() else 0

    }

    override fun partTwo(): Any {
        var cx=dataList2.size/2
        var cy=dataList2.size/2
        dataList2[cx][cy]=1
        cy++
        dataList2[cx][cy]=1
        direction=north
        repeat(361525){
            when(direction){
                north -> {
                    cx--
                    dataList2[cx][cy]=getSum(cx, cy)
                    if(dataList2[cx][cy-1]==-1L)
                        direction=west
                }
                west ->{
                    cy--
                    dataList2[cx][cy]=getSum(cx, cy)
                    if(dataList2[cx+1][cy]==-1L)
                        direction=south
                }
                south -> {
                    cx++
                    dataList2[cx][cy]=getSum(cx, cy)
                    if(dataList2[cx][cy+1]==-1L)
                        direction=east
                }
                east -> {
                    cy++
                    dataList2[cx][cy]=getSum(cx, cy)
                    if(dataList2[cx-1][cy]==-1L)
                        direction=north
                }
            }
            if(dataList2[cx][cy]>361527)
                return dataList2[cx][cy]
        }
        return dataList2[cx][cy]
    }
}