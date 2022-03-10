package com.app.adventofcode.year21

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day10(context: Context): Day(context,10,2021) {

    private val TAG="SyntaxScoring"
    private val A=3
    private var sumA=0
    private val B=57
    private var sumB=0
    private val C=1197
    private var sumC=0
    private val D=25137
    private var sumD=0


    private var pointsA: Long=1
    private var pointsB: Long=2
    private var pointsC: Long=3
    private var pointsD: Long=4

    private var sumPoints: Long=0
    private val inCompleteLine: ArrayList<String> = ArrayList()
    private val completeValue: ArrayList<Long> = ArrayList()

    override fun partOne(): Any {
        for (value in listItem){
            when(checkPartOne(value.toCharArray().toList() as ArrayList<Char>)){
                ')' -> sumA++
                '}' -> sumC++
                ']' -> sumB++
                '>' -> sumD++
                else -> {

                }
            }
        }
        val sum=(A*sumA) + (B*sumB) + (C*sumC) + (D*sumD)
       return sum
    }

    override fun partTwo(): Any {
        for (value in inCompleteLine){
            sumPoints=0
            val data=charPartTwo(value.toCharArray().toList() as ArrayList<Char>)
            for(x in data.indices){
                when (data[x]) {
                    ')' -> {
                        sumPoints*=5
                        sumPoints+=pointsA
                    }
                    '}' -> {
                        sumPoints*=5
                        sumPoints+=pointsC
                    }
                    ']' -> {
                        sumPoints*=5
                        sumPoints+=pointsB
                    }
                    '>' -> {
                        sumPoints*=5
                        sumPoints+=pointsD
                    }
                }
            }
            completeValue.add(sumPoints)
        }

        completeValue.sort()
        return completeValue[((completeValue.size)/2).toInt()]
    }

    private fun charPartTwo(item: ArrayList<Char>): String{
        var data=""
        for(index in item.size-1 downTo 0){
            val element=item[index]
            when (element) {
                '(' -> {
                    data+=")"
                }
                '{' -> {
                    data+="}"
                }
                '[' -> {
                    data+="]"
                }
                '<' -> {
                    data+=">"
                }
            }
        }
        return data
    }


    private fun checkPartOne(item : ArrayList<Char>) : Char{
        for((index, element) in item.withIndex()){
            if(index==0){
                when (element) {
                    ')' -> {
                        return element
                    }
                    '}' -> {
                        return element
                    }
                    ']' -> {
                        return element
                    }
                    '>' -> {
                        return element
                    }
                }
            }
            when (element) {
                ')' -> {
                    return if(item[index-1] =='('){
                        item.removeAt(index)
                        item.removeAt(index-1)
                        checkPartOne(item)
                    }else {
                        element
                    }
                }
                '}' -> {
                    return if(item[index-1] =='{'){
                        item.removeAt(index)
                        item.removeAt(index-1)
                        checkPartOne(item)
                    }else {
                        element
                    }
                }
                ']' -> {
                    return if(item[index-1] =='['){
                        item.removeAt(index)
                        item.removeAt(index-1)
                        checkPartOne(item)
                    }else {
                        element
                    }
                }
                '>' -> {
                    return if(item[index-1] =='<'){
                        item.removeAt(index)
                        item.removeAt(index-1)
                        checkPartOne(item)
                    }else {
                        element
                    }
                }
            }
        }
        inCompleteLine.add(item.joinToString(""))
        return '-'
    }
}