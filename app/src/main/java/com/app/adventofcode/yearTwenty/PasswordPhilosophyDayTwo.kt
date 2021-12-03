package com.app.adventofcode.yearTwenty

import android.util.Log

class PasswordPhilosophyDayTwo(private var listItem: ArrayList<String>) {

    private val TAG="PasswordPhilosophy"
    fun partOne(): Int {
        var count=0;
        for(item in listItem){
            val sentence: List<String> = item.split(" ")
            val firstData: List<String> =sentence[0].split("-")
            val least=firstData[0].toInt()
            val most=firstData[1].toInt()
            Log.d("TAG", "getValid: $sentence")
            val secondData=sentence[1].replace(":","").trim()
            Log.d(TAG, "getValid: second $secondData")
            val thirdData=sentence[2]
            Log.d(TAG, "getValid: $thirdData $least $most")
           val total=thirdData.length-thirdData.replace(secondData,"").trim().length
            if(total in least..most)
                count++

        }
        return count
    }

    fun partTwo(): Int {
        var count=0;
        for(item in listItem){
            val sentence: List<String> = item.split(" ")
            val firstData: List<String> =sentence[0].split("-")
            val least=firstData[0].toInt()
            val most=firstData[1].toInt()
            Log.d("TAG", "getValid: $sentence")
            val secondData=sentence[1].replace(":","").trim()
            Log.d(TAG, "getValid: second $secondData")
            val thirdData=sentence[2]
            Log.d(TAG, "getValid: $thirdData $least $most")
            if (thirdData[least-1].toString() != secondData || thirdData[most-1].toString() != secondData) {
                if(thirdData[least-1].toString()==secondData){
                    count++
                }else if(thirdData[most-1].toString()==secondData){
                    count++
                }
            }

        }
       return count
    }

}