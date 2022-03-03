package com.app.adventofcode.year17

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day05(context: Context): Day(context,5,2017) {


    override fun partOne(): Any {
        val list=IntArray(listItem.size)
        for ((index,ele) in listItem.withIndex()){
            list[index]=ele.toInt()
        }
        return return jump(list, { 1 })
    }

    override fun partTwo(): Any {
        val list=IntArray(listItem.size)
        for ((index,ele) in listItem.withIndex()){
            list[index]=ele.toInt()
        }
        return jump(list, { if(it>2) -1 else 1})
    }

    private tailrec fun jump(offset: IntArray, mutator: (Int) -> Int, pc: Int=0, steps:Int=0) :Int =
        if(pc<0 || pc>=offset.size) steps
        else{
        val nextpc = pc+offset[pc]
            offset[pc]+=mutator(offset[pc])
            jump(offset,mutator,nextpc,steps.inc())
        }
}