package com.app.adventofcode.year17

import android.content.Context
import com.app.adventofcode.Day

class Day08(context: Context): Day(context,8,2017) {

    override fun partOne(): Any {
        val hashMap=HashMap<String,Long>()
        listItem1.forEach {
            val data=it.split(" ")
            var registerValue=hashMap[data[0]] ?: 0L
            val index=data.indexOf("if")
            if(check(hashMap,data[index+1],data[index+2],data[index+3])){
                if(data[1]=="inc"){
                    registerValue+=data[2].toLong()
                }else if(data[1]=="dec"){
                    registerValue-=data[2].toLong()
                }
            }
            hashMap[data[0]]=registerValue
        }
        return hashMap.maxOfOrNull { it.value }!!
    }

    private fun check(data: HashMap<String,Long>,leftR: String,condition: String,value:String): Boolean {
        when (condition) {
            "<" -> {
                val registerValue=data[leftR] ?: 0L
                return registerValue<value.toLong()
            }

            ">" -> {
                val registerValue=data[leftR] ?: 0L
                return registerValue>value.toLong()
            }

            ">=" ->{
                val registerValue=data[leftR] ?: 0L
                return registerValue>=value.toLong()
            }

            "<=" -> {
                val registerValue=data[leftR] ?: 0L
                return registerValue<=value.toLong()
            }

            "==" ->{
                val registerValue=data[leftR] ?: 0L
                return registerValue==value.toLong()
            }
            "!=" -> {
                val registerValue=data[leftR] ?: 0L
                return registerValue!=value.toLong()
            }
        }
        return false
    }

    override fun partTwo(): Any {
        var maxValue=0L
        val hashMap=HashMap<String,Long>()
        listItem1.forEach {
            val data=it.split(" ")
            var registerValue=hashMap[data[0]] ?: 0L
            val index=data.indexOf("if")
            if(check(hashMap,data[index+1],data[index+2],data[index+3])){
                if(data[1]=="inc"){
                    registerValue+=data[2].toLong()
                }else if(data[1]=="dec"){
                    registerValue-=data[2].toLong()
                }
            }
            if(maxValue<registerValue)
                maxValue=registerValue
            hashMap[data[0]]=registerValue
        }
        return maxValue
    }
}