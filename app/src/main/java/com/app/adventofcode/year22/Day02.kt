package com.app.adventofcode.year22

import android.content.Context
import com.app.adventofcode.Day

class Day02(context: Context) : Day(context,2,2022) {
    override fun partOne(): Any {
        var sum=0
        listItem.forEach {
            val game=it.trim().split(" ")
            val opp=getCoinValues(game[0].trim())
            val myself=getCoinValues(game[1].trim())
            sum += if(myself==opp){
                myself+3
            } else if(winCheck(opp, myself))
                myself+6
            else myself
        }
        return sum
    }

    private fun getCoinValues(value: String) : Int = if(value=="A" || value=="X") 1 else if(value=="B" || value=="Y") 2 else 3

    private fun winCheck(opp: Int , myself: Int) : Boolean = (opp==1 && myself==2) || (opp==2 && myself==3) || (opp==3 && myself==1)

    override fun partTwo(): Any {
        var sum=0
        listItem.forEach {
            val game=it.trim().split(" ")
            val opp=getCoinValues(game[0].trim())
            val myself=getCoinValues(game[1].trim())
            sum += if(myself==1){
                if(winCheck(opp, myself)) loseIt(opp) else myself
            }else if(myself==2){
                opp+3
            }else{
                if(winCheck(opp, myself)) myself+6 else winIt(opp)+6
            }
        }
        return sum
    }

    private fun loseIt(value: Int) : Int = if(value==1) 3 else 2

    private fun winIt(value: Int) : Int =  if(value==2) 1 else 2

}
