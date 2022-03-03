package com.app.adventofcode.yearNineTeen

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day

class Day02(context: Context): Day(context,2,2019) {
private val TAG="ProgramAlarm"
    override fun partOne(): Long {
        var numbers=listItem[0].split(",").toList().toMutableList()
        numbers[1]= 12.toString()
        numbers[2]= 2.toString()
        alarm(numbers,0)
        return numbers[0].toLong()
    }

    private fun alarm(numbers: MutableList<String>, pos: Int): Long {
        when {
            numbers[pos].toInt()==1 -> {
                val values=numbers[numbers[pos+1].toInt()].toInt()+numbers[numbers[pos+2].toInt()].toInt()
                numbers[numbers[pos+3].toInt()]=values.toString()
                alarm(numbers,pos+4)
            }
            numbers[pos].toInt()==2 -> {
                val values=numbers[numbers[pos+1].toInt()].toInt()*numbers[numbers[pos+2].toInt()].toInt()
                numbers[numbers[pos+3].toInt()]=values.toString()
                alarm(numbers,pos+4)
            }
            else -> {
                return numbers[0].toLong()
            }
        }
        return numbers[0].toLong()
    }

    override fun partTwo(): Long{
        for (x in 0 until 99){
            for (y in 0 until 99){
                val numbers=listItem[0].split(",").toList().toMutableList()
                numbers[1]=x.toString()
                numbers[2]=y.toString()
                val value=alarm(numbers,0)
                if(value==(19690720).toLong()){
                    return (100 * x + y).toLong()
                }
            }
        }
        return 0
    }
}