package com.app.adventofcode.yearTwenty

import android.util.Log
import kotlin.math.cos

class HandyHaversacksDaySeven(private var listItem: ArrayList<String>) {
private val TAG="HandyHaversacks"
    private var hashMapPartOne:HashMap<String,String> = HashMap()
    private var hashMapPartTwo:HashMap<String,String> = HashMap()
    private var sum=0
    private var sumPart=0
    fun init(){
        for (data in listItem){
            val bags=data.trim().split("contain")
            hashMapPartOne[bags[0].trim()]=bags[1].trim().replace(Regex("[0-9]"),"")
            hashMapPartTwo[bags[0].trim()]=bags[1].trim()
        }

    }

    fun partOne(){
        for(item in hashMapPartOne.keys){
            if(check(item)){

            }
        }
        Log.d(TAG, "partOne: sum $sum")
    }

    fun partTwo(){
        checkPartTwo("shiny gold bags",1)
        Log.d(TAG, "partTwo: sum part $sumPart")
    }

    fun checkPartTwo(value: String,cost: Int): Int{
        var keyValue=value.trim().replace(".","")
        if(!keyValue.endsWith("s"))
            keyValue+="s"
        val dataValue=hashMapPartTwo[keyValue]?.trim()
        if(dataValue?.contains("no other bags") == true){
            return 1
        }
        else{
            if(dataValue?.contains(",") == true){
                var flag=0
                var array=dataValue.split(",")
                for(x in array){
                    val arrayString=splitNumString(x.trim())
                    sumPart+= cost*arrayString[0].toInt()
                    flag+=arrayString[0].toInt()* checkPartTwo(arrayString[1],cost* arrayString[0].toInt())
                }
                return flag
            }else if(dataValue?.contains(",")==false){
                val arrayString=splitNumString(dataValue.trim())
                sumPart+=cost*arrayString[0].toInt()
                return (arrayString[0].toInt()* checkPartTwo(arrayString[1],cost* arrayString[0].toInt()))
            }
        }
        return 0
    }

    fun splitNumString(values: String): Array<String>{
        val string= arrayOf("","")
        val data=values.split(" ")
        string[0]=data[0].trim()
        for(x in 1 until data.size){
            string[1]+=" "+data[x]
        }
        string[1].trim()
        return string
    }


    fun check(value: String): Boolean{
        var keyValue=value.replace(".","")
        if(!keyValue.endsWith("s"))
            keyValue+="s"
        val dataValue=hashMapPartOne[keyValue]?.trim()
        if(dataValue?.contains("no other bags") == true){
            return false
        }else if(dataValue?.contains("shiny gold bag") == true) {
            sum++
            return true
        }
        else{
            if(dataValue?.contains(",") == true){
                var flag=true
                var array=dataValue.split(",")
                for(x in array){
                    flag=check(x.trim())
                    if(flag)
                        return true
                }
                return flag
            }else if(dataValue?.contains(",")==false){
                return check(dataValue)
            }
        }
        return false
    }
}