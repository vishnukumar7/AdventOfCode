package com.app.adventofcode.yearTwenty

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Day06(context: Context): Day(context,6,2020) {
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

    override fun partTwo(): Int {
       var count=0
        for(item in listItemMultiList){
            count+=getAnswered(item)
        }
        return  count
    }

    override fun partOne(): Int {
        var count=0
        for(item in listItem){
            val mergeValue=item.replace(" ","")
            val hashChar=mergeValue.trim().toCharArray().toMutableSet()
            count+=hashChar.size
        }
        return count
    }
}