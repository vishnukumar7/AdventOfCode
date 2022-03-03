package com.app.adventofcode.year15

import android.content.Context
import com.app.adventofcode.Day

class Day05(context: Context): Day(context,5,2015) {

    override fun partOne(): Int {
        var sum = 0
        for (item in listItem) {
            val vowelCount =
                item.count { it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' }
            if (vowelCount < 3)
                continue
            var prev = '-'
            var doubleLetter=false
            for (it in item.toCharArray().toList()) {
                if (it != prev) {
                    prev=it
                }else {
                    doubleLetter = true
                    break
                }
            }
            if(!doubleLetter)
                continue

            if(item.contains("ab") || item.contains("cd") || item.contains("pq") || item.contains("xy"))
                continue

            sum++
        }
        return sum
    }

    override fun partTwo(): Int {
        var sum = 0
        for (item in listItem) {
            var case1=false
            var case2=false
           for(index in 0 until item.toCharArray().size-2){
                if(!case1){
                    val first=item.substring(index,index+2)
                    val repeat=item.substring(index+2)
                    if(repeat.contains(first))
                        case1=true
                }

               if(!case2){
                   val between=item.substring(index,index+3)
                   if(between[0]==between[2])
                       case2=true
               }
           }
            if(case1 && case2)
            sum++
        }
        return sum
    }
}