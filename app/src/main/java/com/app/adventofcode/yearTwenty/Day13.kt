package com.app.adventofcode.yearTwenty

import android.content.Context
import android.util.Log
import com.app.adventofcode.Day
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Day13(context: Context): Day(context,13,2020) {

private val TAG="ShuttleSearch"
    override fun partOne(){
        val earliestTimeStamp=listItem[0].toLong()
        val arraysList=listItem[1].split(",").toList() as ArrayList<String>
        arraysList.removeIf { name -> name == "x" }
        var smaller=Long.MAX_VALUE
        var dataValues: Long=0
        for (item in arraysList){
            val rem=earliestTimeStamp%item.toLong()
            val marked=earliestTimeStamp-rem+item.toLong()
            if(smaller>marked){
                smaller=marked
                dataValues=item.toLong()
            }
        }
        Log.d(TAG, "partOne: value ${(smaller-earliestTimeStamp)*dataValues}")

    }

    override fun partTwo(){
        val earliestTimeStamp=listItem[0].toLong()
        val arraysList=listItem[1].split(",").toList() as ArrayList<String>
        arraysList.removeIf { name -> name == "x" }
        val arraysList1=listItem[1].split(",").toList() as ArrayList<String>
        val arrayItemTimeStamp =IntArray(arraysList.size)
        val arrayItemListTemp =IntArray(arraysList.size)
        val arrayItemList =IntArray(arraysList.size)
        var pos=0
        for ((index,element) in arraysList1.withIndex()){
            if(element!="x") {
                arrayItemTimeStamp[pos]=index
                arrayItemList[pos]=element.toInt()
                arrayItemListTemp[pos]=element.toInt()+index
                pos++
            }
        }

        val arrList=TreeSet<Int>()
        var item: Long=0
        Log.d(TAG, "partTwo: ${arraysList.size} ")
        Log.d(TAG, "partTwo: "+arrayItemList.size)
        arrayItemList.forEach { value -> print("$value ") }
        Log.d(TAG, "partTwo: "+arrayItemListTemp.size)
        arrayItemListTemp.forEach { value -> print("$value ") }
        Log.d(TAG, "partTwo: "+arrayItemTimeStamp.size)
        arrayItemTimeStamp.forEach { value -> print("$value ") }
       /* while (item<1068781){
            arrList.clear()
            for((listIndex,elements) in  arrayItemList.withIndex()){
                arrayItemListTemp[listIndex]=arrayItemListTemp[listIndex]-1
                if(arrayItemListTemp[listIndex]==0){
                    arrList.add(elements)
                    if(arrList.size==0 || (arrList.size==1 && arrList.contains(arrayItemList[0]))){
                        arrayItemListTemp[listIndex]=arrayItemList[listIndex]
                    }else{
                        arrayItemListTemp[listIndex]=arrayItemList[listIndex]+arrayItemTimeStamp[listIndex]
                    }
                }
            }
            if(arrList.size==arraysList.size)
                break
            item++
        }*/
        var flag=true
        var smaller=3417
        while (flag) {
            arrList.clear()
            for ((listIndex, elements) in arrayItemList.withIndex()) {
               /* if(smaller==arrayItemListTemp[listIndex])
                    arrList.add(elements)
                if(smaller<arrayItemListTemp[listIndex] || smaller>arrayItemListTemp[listIndex]){
                    arrayItemListTemp[listIndex]+=elements
                    smaller=arrayItemListTemp[listIndex]
                }*/
                while (arrayItemListTemp[listIndex]<3417){
                    arrayItemListTemp[listIndex]+=elements
                }
            }
            if(smaller>=3417){
                flag=false
            }
            Log.d(TAG, "partTwo: smaller $smaller")
            if(arrList.size==arrayItemList.size) {
                flag=false
            }
        }
        Log.d(TAG, "partTwo: values ")
        for(itemValues in arrayItemListTemp){
            Log.d(TAG, "partTwo: $itemValues")
        }
        Log.d(TAG, "partTwo: item $smaller")



    }

    fun partTwo2(){
        val earliestTimeStamp=listItem[0].toLong()
        val arraysList=listItem[1].split(",").toList() as ArrayList<String>
        var first=10000000000000+arraysList.first().toLong()
        var flag=true
        while (flag){
            for((index,elements) in arraysList.withIndex()){
                if(index!=0 && elements!="x"){
                    var data=elements.toLong()
                    val values =first+index.toLong()
                   if(values%data==(0).toLong()){
                       flag=false
                   }
                    else{
                        flag=true
                       break
                   }
                }
            }
            if(flag)
            first+=arraysList.first().toLong()
            Log.d(TAG, "partTwo2: $first")
        }
        Log.d(TAG, "partTwo2: $first")
    }

    fun partTwo3(){
        val earliestTimeStamp=listItem[0].toLong()
        val arraysList=listItem[1].split(",").toList() as ArrayList<String>
        val arrayListLong: ArrayList<Long> =ArrayList()
        for(element in arraysList){
            if (element!="x")
            arrayListLong.add(element.toLong())
        }
        val map: HashMap<String,Long> =HashMap()
        for((index,elements) in arraysList.withIndex()){
            if (elements!="x"){
                map[elements]=index.toLong()
            }
        }

        arrayListLong.sort()
        Log.d(TAG, "partTwo3: "+arrayListLong.first()+ " "+arrayListLong.last())
        var first=arrayListLong.last().toLong()+map[arrayListLong.last().toString()]!!.toLong()
        Log.d(TAG, "partTwo3: first $first")
        var flag=true
        while (flag){
            for((index,elements) in arrayListLong.withIndex()){
                if(index!=0){
var data=first-arraysList.size+index.toLong()
                    if(data%elements==(0).toLong()){
                        flag=false
                    }
                    else{
                        flag=true
                        break
                    }
                }
            }
            if(flag)
                first+=arrayListLong.last().toLong()
        }
        Log.d(TAG, "partTwo2: $first")
    }
}