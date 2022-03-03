package com.app.adventofcode.yearTwenty

import android.content.Context
import com.app.adventofcode.Day

class Day01(context: Context):Day(context,1,2020) {

    override fun partOne() : Long{
        for (first in 0..listItem.size){
            for(second in first+1..listItem.size){
                if(listItem[first].toLong()+listItem[second].toLong()==(2020).toLong()){
                    return (listItem[first].toLong()*listItem[second].toLong())
                }
            }
        }
        return 0
    }

    override fun partTwo(): Long{
        for (first in 0..listItem.size){
            for(second in first+1..listItem.size){
                for(third in second+1..listItem.size){
                    if(listItem[first].toLong()+listItem[second].toLong()+listItem[third].toLong()==(2020).toLong()){
                        return (listItem[first].toLong()*listItem[second].toLong()*listItem[third].toLong())
                    }
                }
            }
        }
        return 0
    }
}