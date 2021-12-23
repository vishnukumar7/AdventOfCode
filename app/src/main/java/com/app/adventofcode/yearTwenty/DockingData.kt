package com.app.adventofcode.yearTwenty

import android.util.Log
import kotlin.math.pow

class DockingData(private var listItem: ArrayList<String>) {
private val TAG="DockingData"
    private var mask: String=""
    val dataHashMap: HashMap<String,Long> = HashMap()

    fun partOne(): Long {
        var mastLength=0
        var sum: Long=0
        for(data in listItem){
            if (data.contains("mask")){
                mask=data.trim().split("=")[1].trim()
                mastLength=mask.length
            }else {
                val dataSplit=data.trim().split("=")
                val dataValues=dataSplit[1].trim()
                var item = Integer.toBinaryString(dataValues.toInt())
                for (index in 0 until mastLength - item.length)
                    item = "0$item"
                val itemStringBuilder = StringBuilder(item)
                for (index in 0 until mastLength) {
                    if (!(mask[index] == 'x' || mask[index] == 'X')) {
                        if (mask[index] != item[index]) {
                            itemStringBuilder[index] = mask[index]
                        }
                    }
                }
                val value=dataSplit[0].trim().replace("mem[","").replace("]","")
                val decimal = getDecimal(itemStringBuilder.toString())
                dataHashMap[value]=decimal
            }
        }
        for(data in dataHashMap.keys){
            sum+= dataHashMap[data]!!
        }
        return sum
    }

    fun partTwo(): Long {
        var sum: Long=0
        for(data in listItem){
            if (data.contains("mask")){
                mask=data.trim().split("=")[1].trim()
            }else {
                val dataSplit=data.trim().split("=")
                val dataValues=dataSplit[1].trim()
                val value=dataSplit[0].trim().replace("mem[","").replace("]","")
                partTwo2(value,dataValues.toLong(),mask)
            }
        }
        Log.d(TAG, "partTwo: $dataHashMap")
        for(data in dataHashMap.keys){
            sum+= dataHashMap[data]!!
        }
        return sum
    }

    private fun getDecimal(value: String): Long {
        var decimal: Long = 0
        for ((n, index) in (value.length-1 downTo 0).withIndex()) {
            decimal += (Character.getNumericValue(value[index]) * 2.0.pow(n.toDouble())).toLong()
        }
        return decimal
    }

    private fun permutation(value: String,index: Int,memoryValue: Long) {
            if(!value.contains('X') || index==-1) {
                dataHashMap[getDecimal(value).toString()]=memoryValue
            }
            else if(value[index]=='X'){
                val stringBuilder=StringBuilder(value)
                stringBuilder[index]='0'
                val value1=stringBuilder.toString()
              //  Log.d(TAG, "permutation: value1 $value1")
                stringBuilder[index]='1'
                val value2=stringBuilder.toString()
               // Log.d(TAG, "permutation: value2 $value2")
                permutation(value1,index-1,memoryValue)
                permutation(value2,index-1,memoryValue)
            }else
                permutation(value,index-1,memoryValue)
    }

    private fun partTwo2(memoryAddress: String,memoryValue: Long,mask: String) {
        var item = Integer.toBinaryString(memoryAddress.toInt())
     //   Log.d(TAG, "partTwo: item  $item")
        var maskIndex=mask.length-1
        val itemStringBuilder = StringBuilder(item)
        for (index in item.length-1 downTo 0) {
            if(mask[maskIndex]=='x' || mask[maskIndex]=='X'){
                itemStringBuilder[index]=mask[maskIndex]
            }else if(item[index]=='0'){
                itemStringBuilder[index]=mask[maskIndex]
            }
            maskIndex--
        }
       // Log.d(TAG, "partTwo: mask  $mask")
      //  Log.d(TAG, "partTwo: value $itemStringBuilder")
        permutation(itemStringBuilder.toString(),itemStringBuilder.length-1,memoryValue)
    }

}