package com.app.adventofcode.yearTwenty

import android.content.Context
import com.app.adventofcode.Day

class Day18(context: Context): Day(context,18,2020) {
private val TAG="OperationOrder"
    override fun partOne(): Long {
        var sum: Long=0
        for(data in listItem){
            var dataValues=data.replace(" ","")
            while (true){
                if(dataValues.contains("+") || dataValues.contains("*") ||  dataValues.contains("(") || dataValues.contains(")")){
                    if(dataValues.contains("(") || dataValues.contains(")")){
                        var startIndex=-1
                        var endIndex=-1
                        for(index in dataValues.indices){
                            if(dataValues[index]=='(') {
                                startIndex = index
                                endIndex=-1
                            }
                            else if(dataValues[index]==')') {
                                endIndex = index
                            }

                            if(startIndex!=-1 && endIndex!=-1){
                                val mid=dataValues.substring(startIndex,endIndex+1)
                                val result =parentheses(dataValues.substring(startIndex+1,endIndex)).toString()
                                dataValues=dataValues.replace(mid,result)
                                startIndex=-1
                                endIndex=-1
                            }
                            if(index+1>=dataValues.length)
                                break
                        }
                    }else{
                        dataValues=parentheses(dataValues).toString()
                    }

                }else
                    break

            }
            sum+=dataValues.toLong()
        }

        return sum
    }

    private fun parentheses(dataValues: String): Long{
        var mid=dataValues
        var sum: Long=0
        while(true){
            if(mid.contains("+")  || mid.contains("*")){
                val digitSplit=mid.split("+","*").toList()
               val symbolSplit=mid.replace("[0-9]".toRegex(),"").toCharArray().toList()
                sum=digitSplit[0].toLong()
                for ((index,values) in symbolSplit.withIndex()){
                    when(values){
                        '*' -> sum*=digitSplit[index+1].toLong()
                        '+' -> sum+=digitSplit[index+1].toLong()
                    }
                }
                mid=sum.toString()
            }else
                break
        }
        return sum
    }

    override fun partTwo(): Long {
        var sum: Long=0
        for(data in listItem){
            var dataValues=data.replace(" ","")
            while (true){
                if(dataValues.contains("+") || dataValues.contains("*") ||  dataValues.contains("(") || dataValues.contains(")")){
                    if(dataValues.contains("(") || dataValues.contains(")")){
                        var startIndex=-1
                        var endIndex=-1
                        for(index in dataValues.indices){
                            if(dataValues[index]=='(') {
                                startIndex = index
                                endIndex=-1
                            }
                            else if(dataValues[index]==')') {
                                endIndex = index
                            }

                            if(startIndex!=-1 && endIndex!=-1){
                                val mid=dataValues.substring(startIndex,endIndex+1)
                                val result =parenthesesPartTwo(dataValues.substring(startIndex+1,endIndex)).toString()
                                dataValues=dataValues.replace(mid,result)
                                startIndex=-1
                                endIndex=-1
                            }
                            if(index+1>=dataValues.length)
                                break
                        }
                    }else{
                        dataValues=parenthesesPartTwo(dataValues).toString()
                    }

                }else
                    break

            }
            sum+=dataValues.toLong()
        }

        return sum
    }

    private fun parenthesesPartTwo(dataValues: String): Long{
        var mid=dataValues
        var sum: Long=0
        var flag=true
        while(flag){
            val digitSplit=mid.split("+","*").toList().toMutableList()
            val symbolSplit= mid.replace("[0-9]".toRegex(),"").toCharArray().toList().toMutableList()
            if(!mid.contains("+") && mid.contains("*")){
                sum=digitSplit[0].toLong()
                for ((index,values) in symbolSplit.withIndex()){
                    sum*=digitSplit[index+1].toLong()
                }
                mid=sum.toString()
            }else if(!mid.contains("*") && mid.contains("+")){
                sum=digitSplit[0].toLong()
                for ((index,values) in symbolSplit.withIndex()){
                    sum+=digitSplit[index+1].toLong()
                }
                mid=sum.toString()
            }else{
                if(mid.contains("+") || mid.contains("*")){
                    mid =""
                    for ((index,values) in symbolSplit.withIndex()){
                        when(values){
                            '*' -> {
                                mid+=digitSplit[index]+"*"
                            }
                            '+' -> {
                                symbolSplit[index]='0'
                                val add=digitSplit[index].toLong()+digitSplit[index+1].toLong()
                                digitSplit[index]=""
                                digitSplit[index+1]=add.toString()
                            }
                        }
                    }
                    if(digitSplit[digitSplit.size-1].isNotEmpty())
                        mid+=digitSplit[digitSplit.size-1]
                }else {
                    flag=false
                }
            }
        }
        return sum
    }


}