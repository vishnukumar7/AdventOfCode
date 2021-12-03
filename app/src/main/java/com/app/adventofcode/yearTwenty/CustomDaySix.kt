package com.app.adventofcode.yearTwenty

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class CustomDaySix(private var listItem: ArrayList<String>,private var multiList: ArrayList<ArrayList<String>>) {
private val TAG="Customs"

    fun getAnswered(itemList: ArrayList<String>): Int {
        var questions=0
        val hashSet=HashSet<Char>()
        for(data in itemList){
            hashSet.addAll(data.trim().toCharArray().toHashSet())
        }
        for(set in hashSet){
            var flag=true
            for (data in itemList){
                if(!data.contains(set.toString())){
                    flag=false
                    break
                }
            }
            if(flag)
                questions++
        }
        return questions
    }

    fun partTwo(): Int {
       var count=0
        for(item in multiList){
            count+=getAnswered(item)
        }
        return  count
    }

    fun partOne(): Int {
        var count=0
        for(item in listItem){
            val mergeValue=item.replace(" ","")
            val hashChar=mergeValue.trim().toCharArray().toMutableSet()
            count+=hashChar.size
        }
        return count
    }
}