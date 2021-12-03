package com.app.adventofcode.yearTwenty

class ReportRepairDayOne(private var listItem: ArrayList<String>) {

    fun partOne() : Long{
        for (first in 0..listItem.size){
            for(second in first+1..listItem.size){
                if(listItem[first].toLong()+listItem[second].toLong()==(2020).toLong()){
                    return (listItem[first].toLong()*listItem[second].toLong())
                }
            }
        }
        return 0
    }

    fun partTwo(): Long{
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