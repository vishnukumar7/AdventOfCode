package com.app.adventofcode.yearTwenty

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import kotlin.math.log

class Day09(context: Context): Day(context,9,2020) {
private val  TAG="EncodingError"
    override fun partOne() :LongArray{
        val dataArray=LongArray(2)
        for (index in 25 until listItem.size){
            val data=listItem[index]
            var flag=false
            for (x in index-25 until index){
                for(y in index-25 until index){
                    if(x!=y && listItem[x].toLong()+listItem[y].toLong()==data.toLong()){
                        flag=true
                        break
                    }
                }
                if(flag)
                    break
            }

            if(!flag) {
                Log.d(TAG, "partOne: index $index")
                dataArray[0]=data.toLong()
                dataArray[1]=index.toLong()
                return dataArray
            }
        }
        return dataArray
    }

    override fun partTwo(): Long{
        val dataArray=partOne()
        val data=dataArray[0]
        val valuesArray =LongArray(dataArray[1].toInt())
        Log.d(TAG, "partTwo: $valuesArray")
        Log.d(TAG, "partTwo: data $data index ${dataArray[1]}")
            for(x in 0 until dataArray[1].toInt()){
              var sum: Long=0
                for (dataIndex in x until dataArray[1].toInt()){
                    sum+=listItem[dataIndex].toLong()
                    Log.d(TAG, "partTwo: index :  ${dataArray[1].toInt()} data :  $data x in $x dataindex :  $dataIndex values arrays : $sum")
                    if(sum== data){
                        return encryptionMessage(x,dataIndex)
                    }

                    if(sum>data)
                        break
                }

            }
        Log.d(TAG, "partTwo: 0 ")
        return 0
    }

    fun encryptionMessage(startIndex: Int,endIndex: Int): Long{
        var smaller=Long.MAX_VALUE
        var large=Long.MIN_VALUE
        for(x in startIndex..endIndex){
            if(listItem[x].toLong()<smaller){
                smaller=listItem[x].toLong()
            }

            if(listItem[x].toLong()>large)
                large=listItem[x].toLong()
        }

        return smaller+large
    }


}