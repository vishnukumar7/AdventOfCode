package com.app.adventofcode.yearNineTeen

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import kotlin.math.ceil
import kotlin.math.floor

class Day01(context: Context): Day(context,1,2019) {
private val  TAG="RocketEquation"
    override fun partOne(): Long {
        var sum: Long=0
        for (item in listItem){
            var dataValues=item.toLong()
            dataValues= floor((dataValues/3).toDouble()).toLong()
            dataValues-=2
            sum+=dataValues
            Log.d(TAG, "partOne: datavalues : ==> $dataValues")
        }

        return sum
    }

    override fun partTwo(): Long {
        var sum: Long=0
        for (item in listItem){
            var dataValues=item.toLong()
            while (dataValues>(0).toLong()){
                dataValues= floor((dataValues/3).toDouble()).toLong()
                dataValues-=2
                if(dataValues<0)
                    break
                sum+=dataValues
                Log.d(TAG, "partTwo: datavalues : ==> $dataValues")

            }
        }

        return sum
    }
}